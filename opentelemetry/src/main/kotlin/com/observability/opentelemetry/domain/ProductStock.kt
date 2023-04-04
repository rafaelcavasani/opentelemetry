package com.observability.opentelemetry.domain

import java.math.BigDecimal

data class ProductStock(
    val id: Int,
    val name: String,
    val price: BigDecimal,
    val stock: Stock
)