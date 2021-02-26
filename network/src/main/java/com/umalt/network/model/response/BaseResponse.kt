package com.umalt.network.model.response

/**
 * Created by Umalt on 2/22/21
 */
class BaseResponse<T : Any?>(
    val result: T,
    val errors: List<ErrorResponse>?
)