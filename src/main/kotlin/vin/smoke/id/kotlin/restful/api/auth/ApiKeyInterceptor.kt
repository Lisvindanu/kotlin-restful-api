package vin.smoke.id.kotlin.restful.api.auth

import org.springframework.stereotype.Component
import org.springframework.ui.ModelMap
import org.springframework.web.context.request.WebRequest
import org.springframework.web.context.request.WebRequestInterceptor
import vin.smoke.id.kotlin.restful.api.error.UnAuthorizedException
import vin.smoke.id.kotlin.restful.api.repository.ApiKeyRepository
import java.lang.Exception
import java.net.http.HttpHeaders

@Component
class ApiKeyInterceptor(val apiKeyRepository: ApiKeyRepository) : WebRequestInterceptor {
    override fun preHandle(request: WebRequest) {
        val apiKey = request.getHeader("X-Api-Key")
        if (apiKey == null) {
            throw UnAuthorizedException()
        }
        if(!apiKeyRepository.existsById(apiKey)) {
            throw UnAuthorizedException()
        }
        // valid
    }

    override fun postHandle(request: WebRequest, model: ModelMap?) {
        //nothing
    }

    override fun afterCompletion(request: WebRequest, ex: Exception?) {
        //nothing
    }
}