package ir.onlineshop.common.aop

import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.After
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Aspect
@Component
class LoggingAspect {

    private val log: Logger = LoggerFactory.getLogger(LoggingAspect::class.java)

    @Before("execution(* ir.onlineshop.service.*.*(..))")
    fun logMethodCall(joinPoint: JoinPoint) {
        log.info(
            "Class [{}] in Method [{}] called with args {}",
            joinPoint.signature.declaringTypeName,
            joinPoint.signature.name,
            joinPoint.args
        )
    }
}