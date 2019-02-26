package com.mg.product.productservice.controller

import com.mg.product.productservice.inlines.logger
import lombok.extern.slf4j.Slf4j


@Slf4j
abstract class AbstractController {
    companion object {
        val log = logger(this)
    }

}