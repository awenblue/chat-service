package com.chat.domain.message.logic

import com.chat.domain.message.MessageData

interface LogicExecutor {

    fun execute(message: MessageData): MessageData

}