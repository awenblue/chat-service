package com.chat.domain.message.logic

import com.awen.common.chat.ChatTagEnum
import com.awen.common.chat.dto.ChatDTO
import com.awen.common.chat.dto.ChatSkuDTO
import com.awen.common.chat.param.SimpleChatParam
import com.awen.common.chat.param.SkuChatParam
import com.chat.domain.message.MessageData
import com.chat.domain.message.handler.MyHandler
import com.chat.domain.util.GsonFactory

class BusinessLogicService: BaseChatService() {


    override fun parseMode(message: MessageData): MessageData {

        val gson = GsonFactory.getDefault()


        val data = message.data

        val dto = when(message.tag) {
            ChatTagEnum.CHAT_TAG_TXT.id->{

                val param = gson.fromJson<SimpleChatParam>(data, SimpleChatParam::class.java)

                ChatDTO(0, param.data)
            }
            ChatTagEnum.CHAT_TAG_IMAGE.id->{
                val param = gson.fromJson<SimpleChatParam>(data, SimpleChatParam::class.java)

                ChatDTO(1, param.data)
            }
            ChatTagEnum.CHAT_TAG_SKU.id->{
                val param = gson.fromJson<SkuChatParam>(data, SkuChatParam::class.java)

                ChatSkuDTO(param.skuId, param.skuName, param.skuImage)
            }
            else -> {
                ChatDTO(-1, "暂不支持此消息类型")
            }
        }

        dto.msgId = MyHandler.MSG_ID.incrementAndGet()
        dto.setTag(message.tag)

        message.data = gson.toJson(dto)

        return message
    }



}