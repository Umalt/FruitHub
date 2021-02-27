package com.umalt.domain.product.usecase

import com.umalt.domain.product.port.ProductRepository

/**
 * Created by Umalt on 2/27/21
 */
class DeleteAllProductsUseCase(private val repository: ProductRepository) {
    suspend fun execute() {
        repository.deleteAll()
    }
}