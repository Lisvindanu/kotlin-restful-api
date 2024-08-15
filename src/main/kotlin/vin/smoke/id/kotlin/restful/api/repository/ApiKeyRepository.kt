package vin.smoke.id.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import vin.smoke.id.kotlin.restful.api.entity.ApiKey

interface ApiKeyRepository: JpaRepository<ApiKey, String> {

}