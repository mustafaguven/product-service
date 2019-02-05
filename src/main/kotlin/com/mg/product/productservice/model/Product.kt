package com.mg.product.productservice.model

import com.google.gson.annotations.SerializedName

data class Product(
        @SerializedName("id") val id: Int,
        @SerializedName("sku") val sku: String,
        @SerializedName("imageUri") val imageUri: String? = null,
        @SerializedName("description") val description: String)
