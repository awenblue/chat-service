package com.chat.domain.service

interface Session<T> {

    fun getId(): Long

    fun getSid(): String

    fun disConn()

    fun push(msg: T)

    fun checkStatue(): Boolean

    override fun hashCode(): Int
}