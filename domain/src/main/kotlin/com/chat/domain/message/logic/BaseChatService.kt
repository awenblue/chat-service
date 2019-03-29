package com.chat.domain.message.logic

import com.chat.domain.message.MessageData

abstract class BaseChatService: LogicExecutor {

    override fun execute(message: MessageData): MessageData {
        val baseResult = parseMode(message)

        return createMessage(baseResult)
    }

    private fun createMessage(baseResult: MessageData): MessageData {

        //val json = GsonFactory.getDefault().toJson(baseResult)

        return baseResult
    }

    abstract fun parseMode(message: MessageData): MessageData


}