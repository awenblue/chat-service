package com.awen.common.chat

enum class ChatTagEnum(val id: Int, val desc: String) {

    CHAT_TAG_INIT(0x1000, "请求连接"),
    CHAT_TAG_TXT(0x1001, "文本"),
    CHAT_TAG_IMAGE(0x1002, "图片"),
    CHAT_TAG_SKU(0x1003, "商品"),


    CHAT_TAG_CONNECTED(0x2000, "通过连接"),

    CHAT_TAG_REFUSE(0x2001, "拒绝连接"),
    CHAT_TAG_NOT_ONLINE(0x2002, "对方不在线"),
    CHAT_TAG_INIT_FIRST(0x2003, "需要初始化连接"),









}