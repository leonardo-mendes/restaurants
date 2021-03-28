package com.restaurant.searcher.error

import com.restaurant.searcher.error.domain.ErrorMessage
import com.restaurant.searcher.error.exception.InvalidFieldRequestException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler


@ControllerAdvice
class SearcherExceptionHandler {

    @ExceptionHandler(InvalidFieldRequestException::class)
    fun handleMethodArgumentTypeMismatch(exception: InvalidFieldRequestException) =
        ResponseEntity<ErrorMessage>(ErrorMessage(exception.message!!), HttpStatus.BAD_REQUEST)
}