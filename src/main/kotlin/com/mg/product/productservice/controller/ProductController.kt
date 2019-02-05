package com.mg.product.productservice.controller

import com.mg.product.productservice.model.Product
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.collections.HashMap

@RefreshScope
@RestController
class ProductController : AbstractController() {

    @Value("\${app.id}")
    private val instance: String? = null

    private val productMap by lazy {
        val data = HashMap<Int, Product>()
        data[0] = Product(id = 1, sku = "111111", description = "Linda Black Golden Icon Jean Gömlek")
        data[1] = Product(id = 2, sku = "2222", description = "Ikinci urun")
        data[2] = Product(id = 3, sku = "3333", description = "Ucuncu urun")
        data
    }

    @HystrixCommand(fallbackMethod = "fallback")
    @RequestMapping(value = ["/all"])
    fun all(): ArrayList<Product> {
        val i = Random().nextInt(10)

        log.info("$i RANDOM")
        if (i > 5) {
            throw RuntimeException()
        }
        log.info("$instance cagirildi")
        return ArrayList(productMap.values)
    }

    @RequestMapping(value = ["/"])
    fun instanceId() = "{ \"running_instance_id\": \"$instance\"}"

    @RequestMapping(value = ["/{id}"])
    fun getCatalog(@PathVariable("id") id: Int?): Product {
        return productMap[id]!!
    }

    fun fallback(): ArrayList<Product> {
        val products = ArrayList<Product>()
        products.add(Product(id = 1, sku = "Urun YOK", description = "DESCRIPTION YOK"))
        return products
    }
}
