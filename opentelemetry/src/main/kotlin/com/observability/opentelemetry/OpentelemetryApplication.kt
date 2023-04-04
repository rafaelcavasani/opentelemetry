package com.observability.opentelemetry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.openfeign.EnableFeignClients

@SpringBootApplication
@EnableFeignClients
class OpentelemetryApplication

fun main(args: Array<String>) {
	runApplication<OpentelemetryApplication>(*args)
}
