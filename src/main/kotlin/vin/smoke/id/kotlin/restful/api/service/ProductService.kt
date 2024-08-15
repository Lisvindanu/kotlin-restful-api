package vin.smoke.id.kotlin.restful.api.service

import vin.smoke.id.kotlin.restful.api.entity.Product
import vin.smoke.id.kotlin.restful.api.model.CreateProductRequest
import vin.smoke.id.kotlin.restful.api.model.ListProductRequest
import vin.smoke.id.kotlin.restful.api.model.ProductResponse
import vin.smoke.id.kotlin.restful.api.model.UpdateProductRequest

interface ProductService {
    fun create(createProductRequest: CreateProductRequest) : ProductResponse
    fun get(id: String) : ProductResponse
    fun update(id: String, updateProductRequest: UpdateProductRequest) : ProductResponse
    fun delete(id: String)
    fun list(listProductRequest: ListProductRequest) : List<ProductResponse>
}