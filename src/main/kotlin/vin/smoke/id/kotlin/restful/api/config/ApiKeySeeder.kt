package vin.smoke.id.kotlin.restful.api.config

import org.springframework.boot.ApplicationArguments
import org.springframework.boot.ApplicationRunner
import org.springframework.stereotype.Component
import vin.smoke.id.kotlin.restful.api.entity.ApiKey
import vin.smoke.id.kotlin.restful.api.repository.ApiKeyRepository

@Component
class ApiKeySeeder(val apiKeyRepository: ApiKeyRepository) : ApplicationRunner {
    val apiKey = "Secret"
    override fun run(args: ApplicationArguments?) {
        if(!apiKeyRepository.existsById(apiKey)) {
            val entity = ApiKey(id = apiKey)
            apiKeyRepository.save(entity)
        }
    }
}