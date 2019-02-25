package com.mg.product.productservice.service

import com.fasterxml.jackson.annotation.JsonProperty


data class Order(
        @JsonProperty("id") val id: Int,
        @JsonProperty("sku") val sku: String = "",
        @JsonProperty("imageUri") val imageUri: String? = null,
        @JsonProperty("description") val description: String = "")
