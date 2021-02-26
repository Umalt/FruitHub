package com.umalt.data.base.port

/**
 * Created by Umalt on 2/22/21
 */
interface Cache<T> {
    suspend fun insert(vararg obj: T)

    suspend fun update(vararg obj: T)

    suspend fun delete(vararg obj: T)
}