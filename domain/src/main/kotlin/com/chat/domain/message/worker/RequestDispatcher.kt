package com.chat.domain.message.worker

import com.chat.domain.message.MessageData
import com.chat.domain.message.handler.MyHandler
import com.chat.domain.message.queue.MessageExecutor
import com.chat.domain.message.queue.MessageQueue
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.concurrent.Executor
import javax.annotation.Resource

@Component("reqDispatcher")
class RequestDispatcher: Runnable {

    private val logger = LoggerFactory.getLogger(RequestDispatcher::class.java)
    private var running: Boolean = true

    @Resource
    private lateinit var messageExecutor: Executor

    @Resource
    private lateinit var msgFindExecutor: MessageExecutor

    private val messageQueue: MessageQueue = MyHandler.messageQueue

    private val sleepTime: Long = 100

    override fun run() {
        logger.info("Dispatcher Thread Start...")
        while (this.running) {

            val byteMessage = messageQueue.poll() as MessageData?
            if (byteMessage == null) {
                sleep(sleepTime)
                continue
            }

            val worker = MessageWorker(byteMessage, msgFindExecutor)
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

    private inner class MessageWorker (private val data: MessageData, private val findMsgExecutor: MessageExecutor) : Runnable {

        override fun run() {
            try {
                val executor = findMsgExecutor.findExecutor(data.tag) ?: return

                executor.execute(data).let {
                    MyHandler.respMessageQueue.add(it)
                }

            } catch (e: Exception) {
                e.printStackTrace()
                logger.error("[REQUEST ERROR]", e.cause)
            } finally {

            }
        }
    }
}