package com.observability.opentelclient

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class OpentelClientApplication

fun main(args: Array<String>) {
	runApplication<OpentelClientApplication>(*args)
}
