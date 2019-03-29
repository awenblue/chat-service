package com.chat.domain.service.impl

import com.chat.domain.service.Session
import com.chat.domain.service.SessionManager
import org.slf4j.LoggerFactory
import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession
import java.util.*
import java.util.concurrent.ConcurrentHashMap


class SessionManagerImpl: SessionManager<TextMessage> {

    private val logger = LoggerFactory.getLogger(SessionManager::class.java)

    private val sessions = ConcurrentHashMap<Long, Session<TextMessage>>()

    companion object {

        @Volatile
        private var manager: SessionManager<TextMessage>? = null

        @Synchronized
        fun getIns(): SessionManager<TextMessage> {
            if (manager == null) {
                synchronized(SessionManagerImpl::class.java) {
                    if (manager == null) {
                        manager = SessionManagerImpl()
                    }
                }
            }
            return manager!!
        }
    }

    override fun add(session: Session<TextMessage>) {
        val put = sessions.put(session.getId(), session)
        logger.debug("[SessionManager] add key {} value {} result {}", session.getId(), session, put)
    }

    override fun remove(session: Session<TextMessage>) {
        val remove = sessions.remove(session.getId(), session)
        logger.debug("[SessionManager] remove key {} result {}", session.getId(), remove)
    }

    override fun get(id: Long): Session<TextMessage> {
        return Optional.ofNullable(sessions[id]).orElse(EmptySession)
    }

    override fun get(context: WebSocketSession): Session<TextMessage> {

        return sessions.searchValues(1) {e->
            if (e.getSid() == context.id) {
                e
            } else {
                EmptySession
            }
        }
    }

    override fun getAll(): Map<Long, Session<TextMessage>> {
        return ConcurrentHashMap(sessions)
    }

    override fun count(): Int {
        return sessions.size
    }

}