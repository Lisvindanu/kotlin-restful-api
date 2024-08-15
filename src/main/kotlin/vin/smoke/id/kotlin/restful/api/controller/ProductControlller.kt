package vin.smoke.id.kotlin.restful.api.controller

import org.springframework.web.bind.annotation.*
import vin.smoke.id.kotlin.restful.api.model.*
import vin.smoke.id.kotlin.restful.api.service.ProductService

@RestController
class ProductControlller(val productService: ProductService) {

    @PostMapping(
        value = ["/api/products"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateProductRequest): WebResponse<ProductResponse> {
        val produceResponse = productService.create(body)

        return WebResponse(
            code = 200,
            status = "ok",
            data = produceResponse
        )
    }

    @GetMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun getProduct(@PathVariable("id") id : String): WebResponse<ProductResponse> {
        val productResponse = productService.get(id)
        return WebResponse(
            code = 200,
            status = "ok",
            data = productResponse
        )
    }

    @PutMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateProduct(@PathVariable("id") id:String,
                      @RequestBody updateProductRequest: UpdateProductRequest): WebResponse<ProductResponse> {
        val productResponse = productService.update(id, updateProductRequest)
        return WebResponse(
            code = 200,
            status = "ok",
            data = productResponse
        )
    }
    @DeleteMapping(
        value = ["/api/products/{id}"],
        produces = ["application/json"]
    )
    fun deleteProduct(@PathVariable("id") id: String): WebResponse<String> {
        productService.delete(id)
        return WebResponse(
            code = 200,
            status = "ok",
            data = id

        )
    }

    @GetMapping(
        value = ["/api/products"],
        produces = ["application/json"]
    )
    fun listProducts(@RequestParam(value = "size", defaultValue = "10") size: Int,
                     @RequestParam(value = "page", defaultValue = "0")  page: Int ): WebResponse<List<ProductResponse>>{
        val request = ListProductRequest(page=page, size=size)
       val response = productService.list(request)
        return WebResponse(
            code = 200,
            status = "ok",
            data = response
        )
    }

}