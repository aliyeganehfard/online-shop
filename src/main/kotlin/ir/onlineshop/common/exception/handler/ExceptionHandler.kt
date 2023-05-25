package ir.onlineshop.common.exception.handler

import ir.onlineshop.common.exception.OnlineShopException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(OnlineShopException::class)
    fun handleOnlineShopException(exception: OnlineShopException): String{
        return exception.message.toString()
    }
}