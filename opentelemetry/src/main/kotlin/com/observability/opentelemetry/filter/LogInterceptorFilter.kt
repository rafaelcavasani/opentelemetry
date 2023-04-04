package com.observability.opentelemetry.filter

import org.slf4j.LoggerFactory
import org.springframework.cloud.sleuth.Tracer
import org.springframework.core.annotation.Order
import org.springframework.stereotype.Component
import javax.servlet.Filter
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


@Component
@Order(1)
class LogInterceptorFilter(
    private val tracer: Tracer
) : Filter {

    companion object {
        private val logger = LoggerFactory.getLogger(this::class.java)
    }

    override fun doFilter(request: ServletRequest, response: ServletResponse, filter: FilterChain) {
        val req: HttpServletRequest = request as HttpServletRequest
        val res: HttpServletResponse = response as HttpServletResponse
        filter.doFilter(request, response)
    }

}
