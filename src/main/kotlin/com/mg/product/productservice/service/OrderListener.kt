package com.mg.product.productservice.service

import com.mg.product.productservice.config.RabbitMqConfig
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class OrderListener {

    @RabbitListener(queues = [RabbitMqConfig.QUEUE_ORDER_PLACED])
    fun consumeOrderPlaced(order: Order) {
        println(order.id.toString() + "placed icin yakalandi")
    }

    @RabbitListener(queues = [RabbitMqConfig.QUEUE_ORDER_CREATED])
    fun consumeOrderCreated(order: Order) {
        println(order.id.toString() + "created ---> icin yakalandi")
    }

}