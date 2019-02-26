package com.mg.product.productservice.event_messaging

import com.mg.eventbus.RabbitMqConfig
import org.springframework.context.annotation.Configuration

@Configuration
class ProductMessageConfig : RabbitMqConfig() {

    companion object {
        const val QUEUE_ORDER_ALL = "order.all"
        const val QUEUE_ORDER_CREATED = "order.created"
        const val QUEUE_ORDER_PLACED = "order.placed"
    }

}