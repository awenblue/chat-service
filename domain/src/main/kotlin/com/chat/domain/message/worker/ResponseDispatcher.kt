package com.chat.domain.message.worker

import com.chat.domain.message.MessageData
import com.chat.domain.message.handler.MyHandler
import com.chat.domain.message.queue.MessageQueue
import com.chat.domain.service.SessionManager
import com.chat.domain.service.impl.EmptySession
import com.chat.domain.service.impl.SessionManagerImpl
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.socket.TextMessage
import java.util.concurrent.Executor
import javax.annotation.Resource

@Component
class ResponseDispatcher : Runnable {

    private val logger = LoggerFactory.getLogger(ResponseDispatcher::class.java)
    private var running: Boolean = false

    @Resource
    private lateinit var messageExecutor: Executor

    private var messageQueue: MessageQueue
    private var sessionManager: SessionManager<TextMessage>

    private val sleepTime: Long = 100

    constructor() {
        this.running = true
        this.sessionManager = SessionManagerImpl.getIns()
        this.messageQueue = MyHandler.respMessageQueue
    }

    override fun run() {
        logger.info("Dispatcher Thread Start...")
        while (this.running) {
            val byteMessage = messageQueue.poll() as MessageData?
            if (byteMessage == null) {
                sleep(sleepTime)
                continue
            }

            val worker = MessageWorker(byteMessage)
            messageExecutor.execute(worker)
        }
    }

    fun stop() {
        this.running = false
    }

    private fun sleep(mils: Long) {
        try {
            Thread.sleep(mils)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

    }

    private inner class MessageWorker (private val data: MessageData) : Runnable {

        override fun run() {
            try {
                val session = sessionManager[data.receiveId]
                if (session != EmptySession) {

                    logger.info("【聊天返回】${data.data}")
                    logger.info("【聊天返回】${session.getSid()}")
                    logger.info("【聊天返回】${session.checkStatue()}")

                    session.push(TextMessage(data.data))
                }
            } catch (e: Exception) {
                logger.error("[RESPONSE ERROR] : ", e)
            } finally {

            }
        }
    }


}