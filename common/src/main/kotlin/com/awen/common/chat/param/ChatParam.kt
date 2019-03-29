package com.awen.common.chat.param

open class ChatParam: BaseParam {

    /**消息ID */
    var msgId: Long = 0

    var sendId: Long = 0

    var receiveId: Long = 0

    private var tag: Int = 0

    var data1: String = ""

    override fun getTag(): Int {
        return tag
    }

    fun setTag(tag: Int) {
        this.tag = tag
    }
}