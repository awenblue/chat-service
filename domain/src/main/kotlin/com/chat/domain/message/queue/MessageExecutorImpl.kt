package com.chat.domain.message.queue

import com.chat.domain.message.logic.BusinessLogicService
import com.chat.domain.message.logic.LogicExecutor
import org.springframework.stereotype.Component

@Component("msgFindExecutor")
class MessageExecutorImpl: MessageExecutor {

    override fun findExecutor(mode: Int): LogicExecutor? {

        val tag = mode.and(0xFF00)

        return when(tag) {
            0x1000-> {
                BusinessLogicService()
            }
            else-> null
        }
    }

}