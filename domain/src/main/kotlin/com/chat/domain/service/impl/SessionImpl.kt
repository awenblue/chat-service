package com.chat.domain.service.impl

import com.chat.domain.service.Session
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.util.*

class SessionImpl(private val id: Long, private var context: WebSocketSession?): Session<TextMessage> {
    private var ctxHashCode: Int = context.hashCode()

    override fun hashCode(): Int {
        return context.hashCode()
    }

    override fun getId(): Long {
        return id
    }

    override fun getSid(): String {
        return context?.id?:"-1"
    }

    @Synchronized
    override fun disConn() {
        context?.close()
        context = null
    }

    @Synchronized
    override fun push(msg: TextMessage) {
        Optional.ofNullable(context?.isOpen).map {
            if (it)
                context?.sendMessage(msg)
        }
    }

    @Synchronized
    override fun checkStatue(): Boolean {
        if (context  == null)
            return false

        val isOpen = Optional.ofNullable(context?.isOpen).orElse(false)
        if (!isOpen)
            return false

        return true
    }

    override fun equals(other: Any?): Boolean {
        if (other == null)
            return false

        if (context == null)
            return false

        val session = other as Session<TextMessage>
        return session.getId() == getId() && ctxHashCode == hashCode()
    }
}