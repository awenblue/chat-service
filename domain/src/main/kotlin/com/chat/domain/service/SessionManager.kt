package com.chat.domain.service

import org.springframework.web.socket.TextMessage
import org.springframework.web.socket.WebSocketSession

interface SessionManager<T> {


    fun add(session: Session<T>)

    fun remove(session: Session<T>)

    operator fun get(id: Long): Session<TextMessage>

    fun get(context: WebSocketSession): Session<TextMessage>

    fun getAll(): Map<Long, Session<T>>

    fun count(): Int


}