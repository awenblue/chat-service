package com.awen.common.chat.dto

import java.time.Instant

abstract class AbstractDTO: BaseDTO {


    private var tag: Int = 0
    var msgId: Long = 0
    var serverTime: Long = Instant.now().toEpochMilli()

    override fun getTag(): Int {
        return tag
    }

    fun setTag(tag: Int) {
        this.tag = tag
    }

}