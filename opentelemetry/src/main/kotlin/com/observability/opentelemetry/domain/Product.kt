package com.observability.opentelemetry.domain

import java.math.BigDecimal

data class Product(
    val id: Int,
    val name: String,
    val price: BigDecimal
)