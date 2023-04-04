package com.observability.opentelclient.controller

import com.observability.opentelclient.domain.Stock
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import kotlin.random.Random

@RestController
@RequestMapping("/v1/stock")
class StockController {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping("/{productId}")
    fun getProductStock(@PathVariable productId: String): ResponseEntity<Stock> {
        logger.info("M=getProductStock, stage=init, productId=$productId")
        val stock = Stock(
            minStock = Random.nextInt(0, 10),
            currentStock = Random.nextInt(0, 100)
        )
        logger.info("M=getProductStock, stage=finish, productId=${productId}, stock=$stock")
        return ResponseEntity.ok(stock)
    }

}