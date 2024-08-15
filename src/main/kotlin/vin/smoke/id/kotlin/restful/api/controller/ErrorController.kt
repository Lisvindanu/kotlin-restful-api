package vin.smoke.id.kotlin.restful.api.controller

import jakarta.validation.ConstraintViolationException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import vin.smoke.id.kotlin.restful.api.error.NotFoundException
import vin.smoke.id.kotlin.restful.api.error.UnAuthorizedException
import vin.smoke.id.kotlin.restful.api.model.WebResponse


@RestControllerAdvice
class ErrorController {
    @ExceptionHandler(value = [ConstraintViolationException::class])
    fun validationHandler(constraintViolationException: ConstraintViolationException): WebResponse<String> {
        return WebResponse(
            code = 400,
            status = "Bad Request",
            data = constraintViolationException.message!!
        )
    }

    @ExceptionHandler(value = [NotFoundException::class])
    fun  notFound(notFoundException: NotFoundException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "Not Found",
            data = "not found"
        )
    }

    @ExceptionHandler(value = [UnAuthorizedException::class])
    fun  unauthorized(notFoundException: UnAuthorizedException): WebResponse<String> {
        return WebResponse(
            code = 404,
            status = "UNAUTHORIZED",
            data = "Please Put Your Api Keys"
        )
    }

}