package com.observability.opentelemetry.client

import com.observability.opentelemetry.domain.Stock
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@FeignClient(
    name = "stock-client",
    url = "http://localhost:8081"
)
interface StockClient {

    @GetMapping("/v1/stock/{productId}")
    fun getStock(@PathVariable productId: Int): Stock

}