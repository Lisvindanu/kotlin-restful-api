package vin.smoke.id.kotlin.restful.api.auth

import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport

@Component
class ApiKeyConfiguration(val apiKeyInterceptor: ApiKeyInterceptor) : WebMvcConfigurationSupport() {
    override fun addInterceptors(registry: InterceptorRegistry) {
        super.addInterceptors(registry)

        registry.addWebRequestInterceptor(apiKeyInterceptor)
    }

}