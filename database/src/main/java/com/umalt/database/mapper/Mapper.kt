package com.umalt.database.mapper

/**
 * Created by Umalt on 2/23/21
 */
interface Mapper<T, D> {
    fun mapToDBModel(obj: T): D

    fun mapFromDBModel(obj: D): T
}