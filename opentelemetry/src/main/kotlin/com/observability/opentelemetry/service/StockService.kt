package com.observability.opentelemetry.service

import com.observability.opentelemetry.domain.Stock

interface StockService {
    fun getStock(productId: Int): Stock
}