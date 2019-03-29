package com.chat.domain.message

import com.awen.common.chat.param.ChatParam


class MessageData(val tag: Int, var data: String, val senderId: Long, val receiveId: Long) {


    constructor(param: ChatParam, source: String) : this(param.getTag(), source, param.sendId, param.receiveId)


}