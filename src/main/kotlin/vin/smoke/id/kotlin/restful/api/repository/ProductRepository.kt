package vin.smoke.id.kotlin.restful.api.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import vin.smoke.id.kotlin.restful.api.entity.Product

@Repository
interface ProductRepository: JpaRepository<Product, String> {

}