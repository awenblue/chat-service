package com.chat.domain.message.handler

import com.awen.common.chat.ChatTagEnum
import com.awen.common.chat.dto.ChatDTO
import com.awen.common.chat.param.ChatParam
import com.chat.domain.message.MessageData
import com.chat.domain.message.queue.MessageQueue
import com.chat.domain.message.queue.MessageQueueImpl
import com.chat.domain.model.UserModel
import com.chat.domain.service.Session
import com.chat.domain.service.SessionManager
import com.chat.domain.service.impl.EmptySession
import com.chat.domain.service.impl.SessionImpl
import com.chat.domain.service.impl.SessionManagerImpl
import com.chat.domain.util.GsonFactory
import org.slf4j.LoggerFactory
import org.springframework.web.socket.CloseStatus
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketMessage
import org.springframework.web.socket.WebSocketSession
import org.springframework.web.socket.handler.AbstractWebSocketHandler
import java.util.concurrent.atomic.AtomicLong

open class MyHandler : AbstractWebSocketHandler() {

    private val TAG = "MyHandler"
    private val logger = LoggerFactory.getLogger("MyHandler")

    companion object {
        val MSG_ID = AtomicLong(0)

        val messageQueue: MessageQueue = MessageQueueImpl()
        val respMessageQueue: MessageQueue = MessageQueueImpl()
    }

    override fun afterConnectionEstablished(session: WebSocketSession) {
        logger.error(TAG, "afterConnectionEstablished")

        printStatus(true)
    }

    override fun afterConnectionClosed(session: WebSocketSession, status: CloseStatus) {
        logger.error(TAG, "afterConnectionClosed")

        disConnSession(session)
        printStatus(false)
    }

    override fun handleTransportError(session: WebSocketSession, exception: Throwable) {
        logger.error(TAG, exception)

        disConnSession(session)
        printStatus(false)
    }

    override fun handleMessage(session: WebSocketSession, message: WebSocketMessage<*>) {
        logger.error(TAG, "handleMessage")

        val initSessionIfNeed = initSessionIfNeed(session, message)
        if (!initSessionIfNeed) {
            disConnSession(session)
        }
    }

    private fun initSessionIfNeed(session: WebSocketSession, message: WebSocketMessage<*>): Boolean {

        try {
            val msg = message.payload as String
            logger.info("【聊天】$msg")

            val param = GsonFactory.getDefault().fromJson(msg, ChatParam::class.java)

            val tempSession = getManager()[param.sendId]
            if (param.getTag() != ChatTagEnum.CHAT_TAG_INIT.id) {

                if (tempSession == EmptySession || tempSession.getId() != param.sendId) {
                    send(ChatTagEnum.CHAT_TAG_INIT_FIRST, session)
                    return true
                }

                messageQueue.add(MessageData(param, msg))
                return true
            }

            if (tempSession != EmptySession && tempSession.getId() == param.sendId) {
                send(ChatTagEnum.CHAT_TAG_CONNECTED, session)
                return true
            }

            if (param.sendId <= 0) {

                send(ChatTagEnum.CHAT_TAG_REFUSE, session)

                return true
            }

//            val userModel = userDataService.findById(param.sendId)
//            if (userModel.notExist()) {
//                send(ChatTagEnum.CHAT_TAG_REFUSE, session)
//
//                return true
//            }

            val userModel = UserModel(param.sendId)

            bindSession(userModel, session)
            send(ChatTagEnum.CHAT_TAG_CONNECTED, session)

            return true

        } catch (e: Exception) {
            e.printStackTrace()
        }

        return false
    }

    private fun bindSession(userModel: UserModel, ctx: WebSocketSession): Boolean {
        val session = getManager()[userModel.id]
        if (session != EmptySession) {
            printStatus(false)
            removeSession(session)
        }

        //通过数据库查询deviceId
        val tmpSession = SessionImpl(userModel.id, ctx)
        getManager().add(tmpSession)

        return true
    }


    private fun getManager(): SessionManager<TextMessage> {
        return SessionManagerImpl.getIns()
    }

    private fun printStatus(isAdd: Boolean) {
        logger.error("当前会话数:{}, {}", getManager().count(), if (isAdd) "++" else "--")
    }

    private fun removeSession(session: Session<TextMessage>) {
        getManager().remove(session)
        session.disConn()
    }

    private fun disConnSession(ctx: WebSocketSession) {
        val session = getManager().get(ctx)
        if (session != EmptySession) {
            removeSession(session)
        }
        if (ctx.isOpen) {
            ctx.close()
        }
    }

    private fun send(enum: ChatTagEnum, session: WebSocketSession) {
        val chatDTO = ChatDTO(enum.id, enum.desc)
        chatDTO.msgId = MSG_ID.incrementAndGet()

        val textMessage = TextMessage(GsonFactory.getDefault().toJson(chatDTO))

        session.sendMessage(textMessage)
    }
}