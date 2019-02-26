package com.mg.product.productservice.event_messaging.consume

import com.mg.product.productservice.domain.Order
import com.mg.product.productservice.event_messaging.ProductMessageConfig
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.stereotype.Service

@Service
class OrderListener {

    @RabbitListener(queues = [ProductMessageConfig.QUEUE_ORDER_PLACED])
    fun consumeOrderPlaced(order: Order) {
        println(order.id.toString() + "placed icin yakalandi")
    }

    @RabbitListener(queues = [ProductMessageConfig.QUEUE_ORDER_CREATED])
    fun consumeOrderCreated(order: Order) {
        println(order.id.toString() + "created ---> icin yakalandi")
    }

}