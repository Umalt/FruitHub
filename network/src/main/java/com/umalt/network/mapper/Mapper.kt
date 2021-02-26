package com.umalt.network.mapper

/**
 * Created by Umalt on 2/22/21
 */
interface Mapper<T, D> {
    fun mapFromResponse(obj: T): D
}