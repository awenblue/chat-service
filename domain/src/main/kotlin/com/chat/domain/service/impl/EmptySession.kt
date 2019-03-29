package com.chat.domain.service.impl

import com.chat.domain.service.Session
import org.slf4j.LoggerFactory
import org.springframework.web.socket.TextMessage

object EmptySession: Session<TextMessage> {

    private val logger = LoggerFactory.getLogger(EmptySession::class.java)

    override fun getId(): Long {
        return -1
    }

    override fun getSid(): String {
        return "-1"
    }

    override fun disConn() {
        logger.info("AHA I'M DO NOTHING WHEN CALL {}", "disConn()")
    }

    override fun push(msg: TextMessage) {
        logger.info("AHA I'M DO NOTHING WHEN CALL {}", "push()")
    }

    override fun checkStatue(): Boolean {
        return false
    }

    override fun hashCode(): Int {
        return -1
    }
}