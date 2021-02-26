package com.umalt.data.base.mapper

/**
 * Created by Umalt on 2/22/21
 */
interface Mapper<T, D> {

    fun mapToEntity(obj: T): D

    fun mapFromEntity(obj: D): T
}