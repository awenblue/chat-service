package com.chat.domain.message.queue

import java.util.concurrent.ConcurrentLinkedQueue

class MessageQueueImpl: MessageQueue {

    private val requestQueue: java.util.Queue<Any>

    init {
        requestQueue = ConcurrentLinkedQueue<Any>()
    }

    @Synchronized
    override fun poll(): Any? {
        return this.requestQueue.poll()
    }

    @Synchronized
    override fun add(request: Any): Boolean {
        return this.requestQueue.add(request)
    }

}