/*
 *
 *     Copyright 2018 The awen_blue Authors
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package com.chat

import com.chat.domain.message.worker.RequestDispatcher
import com.chat.domain.message.worker.ResponseDispatcher
import org.slf4j.LoggerFactory
import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.core.annotation.Order
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.stereotype.Component
import javax.annotation.Resource

@SpringBootApplication
@EnableScheduling
class Application

@Component
@Order(1)
class MyApplication: ApplicationRunner {

    @Resource
    private lateinit var reqDispatcher: RequestDispatcher

    @Resource
    private lateinit var respDispatcher: ResponseDispatcher


    override fun run(args: ApplicationArguments) {

        Thread(reqDispatcher).start()
        Thread(respDispatcher).start()
    }
}


fun main(args: Array<String>) {

    val logger = LoggerFactory.getLogger(Application::class.java)

    runApplication<Application>(*args)

    logger.info("RUNNING...")

}