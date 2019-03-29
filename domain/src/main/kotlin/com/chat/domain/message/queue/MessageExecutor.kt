package com.chat.domain.message.queue

import com.chat.domain.message.logic.LogicExecutor

interface MessageExecutor{

    fun findExecutor(mode: Int): LogicExecutor?

}