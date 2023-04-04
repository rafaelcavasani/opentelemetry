package com.observability.opentelemetry.service.impl

import com.observability.opentelemetry.client.StockClient
import com.observability.opentelemetry.domain.Stock
import com.observability.opentelemetry.service.StockService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class StockServiceImpl(
    private val stockClient: StockClient
): StockService {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun getStock(productId: Int): Stock {
        logger.info("M=getStock, stage=init, productId=$productId")
        val result = stockClient.getStock(productId)
        logger.info("M=getStock, stage=finish, productId=$productId, stock=$result")
        return result
    }

}