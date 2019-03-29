package com.chat.domain.message.queue

interface MessageQueue {

    fun poll(): Any?

    fun add(request: Any): Boolean

}