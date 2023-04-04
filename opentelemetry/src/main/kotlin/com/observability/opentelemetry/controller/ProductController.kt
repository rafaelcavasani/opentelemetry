package com.observability.opentelemetry.controller

import com.observability.opentelemetry.domain.Product
import com.observability.opentelemetry.domain.ProductStock
import com.observability.opentelemetry.service.StockService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/v1/products")
class ProductController(
    private val stockService: StockService
) {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    @GetMapping
    fun getAllProducts(): ResponseEntity<List<Product>> {
        logger.info("M=getAllProducts, stage=init")
        val productList = listOf(
            Product(1, "Teclado", BigDecimal(10)),
            Product(2, "Mouse", BigDecimal(5)),
            Product(3, "Monitor", BigDecimal(1500)),
            Product(4, "Iphone 10", BigDecimal(1450)),
            Product(5, "Notebook Dell", BigDecimal(5000)),
            Product(6, "Caneta BIC", BigDecimal(2)),
            Product(7, "Fonte para notebook", BigDecimal(100))
        )
        logger.info("M=getAllProducts, stage=finish, products=${productList}")
        return ResponseEntity.ok(productList)
    }

    @GetMapping("/{productId}")
    fun getProduct(@PathVariable productId: Int): ResponseEntity<ProductStock> {
        logger.info("M=getProduct, stage=init, productId=${productId}")
        val stock = stockService.getStock(productId)
        val productStock = ProductStock(
            id = productId,
            name = "Mock product",
            price = BigDecimal(10),
            stock = stock
        )
        logger.info("M=getProduct, stage=finish, productId=${productId}, productStock=${productStock}")
        return ResponseEntity.ok(productStock)
    }

}