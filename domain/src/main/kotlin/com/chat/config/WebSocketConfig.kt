package com.chat.config

import com.chat.domain.message.handler.MyHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.TaskScheduler
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler
import org.springframework.web.socket.config.annotation.EnableWebSocket
import org.springframework.web.socket.config.annotation.WebSocketConfigurer
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry
import java.util.concurrent.Executors


@Configuration
@EnableWebSocket
class WebSocketConfig: WebSocketConfigurer {

    override fun registerWebSocketHandlers(registry: WebSocketHandlerRegistry) {
        registry.addHandler(MyHandler(), "/websocket").setAllowedOrigins("*")
    }

    @Bean
    fun taskScheduler(): TaskScheduler {
        return ConcurrentTaskScheduler(Executors.newSingleThreadScheduledExecutor())
    }

}