    package vin.smoke.id.kotlin.restful.api.service.impl

    import org.springframework.data.domain.PageRequest
    import org.springframework.data.repository.findByIdOrNull
    import org.springframework.stereotype.Service
    import vin.smoke.id.kotlin.restful.api.entity.Product
    import vin.smoke.id.kotlin.restful.api.error.NotFoundException
    import vin.smoke.id.kotlin.restful.api.model.CreateProductRequest
    import vin.smoke.id.kotlin.restful.api.model.ListProductRequest
    import vin.smoke.id.kotlin.restful.api.model.ProductResponse
    import vin.smoke.id.kotlin.restful.api.model.UpdateProductRequest
    import vin.smoke.id.kotlin.restful.api.repository.ProductRepository
    import vin.smoke.id.kotlin.restful.api.service.ProductService
    import vin.smoke.id.kotlin.restful.api.validation.ValidationUtil
    import java.io.Serial
    import java.util.*
    import java.util.stream.Collectors

    @Service
    class ProductServiceImpl(
        val productRepository: ProductRepository,
        val validationUtil: ValidationUtil
        ) : ProductService {
        override fun create(createProductRequest: CreateProductRequest): ProductResponse {
           validationUtil.validate(createProductRequest)
            val product = Product(
                id = createProductRequest.id !!,
                name = createProductRequest.name!!,
                price = createProductRequest.price!!,
                quantity = createProductRequest.quantity!!,
                createdAt = Date(),
                updatedAt = Date()
            )

            productRepository.save(product)
            return convertProductToProductResponse(product)
        }

        override fun get(id: String): ProductResponse {
            val product = findProductByIdOrThrowNotFound(id)
                return convertProductToProductResponse(product)


        }

        override fun update(id: String, updateProductRequest: UpdateProductRequest): ProductResponse {
            val product = findProductByIdOrThrowNotFound(id)

            validationUtil.validate(updateProductRequest)
            product.apply {
                name = updateProductRequest.name!!
                price = updateProductRequest.price!!
                quantity = updateProductRequest.quantity!!
                updatedAt = Date()
            }

            productRepository.save(product)
            return convertProductToProductResponse(product)
        }

        override fun delete(id: String) {
           val product = findProductByIdOrThrowNotFound(id)
            productRepository.delete(product)
        }

        override fun list(listProductRequest: ListProductRequest): List<ProductResponse> {
          val page =  productRepository.findAll(PageRequest.of(listProductRequest.page, listProductRequest.size))
           val product : List<Product> = page.get().collect(Collectors.toList())
            return product.map { convertProductToProductResponse(it) }
        }

        private fun findProductByIdOrThrowNotFound(id: String): Product {
            val product = productRepository.findByIdOrNull(id)
            if(product == null){
                throw NotFoundException()
            } else {
                return product
            }
        }

        private fun convertProductToProductResponse(product: Product): ProductResponse {
            return ProductResponse(
                id = product.id,
                name = product.name,
                price = product.price,
                quantity = product.quantity,
                createdAt = product.createdAt,
                updatedAt = product.updatedAt
            )
        }

    }