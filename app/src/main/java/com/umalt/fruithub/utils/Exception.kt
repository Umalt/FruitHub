package com.umalt.fruithub.utils

import android.util.MalformedJsonException
import com.umalt.fruithub.R
import com.umalt.fruithub.utils.Utils.getString
import com.umalt.network.model.response.*
import org.json.JSONException
import org.json.JSONObject
import retrofit2.HttpException
import java.net.ConnectException
import java.net.NoRouteToHostException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 * Created by Umalt on 2/27/21
 */
fun Exception.handle(): Triple<String, String, String> {
    return when (this) {
        is HttpException -> {
            val error = response()?.errorBody()?.string()?.let { getErrorType(it) }
            when (code()) {
                500 -> {
                    val title = error?.presentationData?.title
                        ?: getString(R.string.error_title_internal_server)
                    val message = error?.presentationData?.message
                        ?: getString(R.string.error_message_internal_server)
                    Triple(error?.details ?: INTERNAL_SERVER, message, title)
                }
                404 -> {
                    val title = error?.presentationData?.title
                        ?: getString(R.string.error_title_page_not_found)
                    val message = error?.presentationData?.message
                        ?: getString(R.string.error_message_page_not_found)
                    Triple(error?.details ?: PAGE_NOT_FOUND, message, title)
                }
                503 -> {
                    val title = error?.presentationData?.title
                        ?: getString(R.string.error_title_server_unavailable)
                    val message = error?.presentationData?.message
                        ?: getString(R.string.error_message_server_unavailable)
                    Triple(error?.details ?: SERVER_UNAVAILABLE, message, title)
                }
                else -> {
                    val title = error?.presentationData?.title ?: getString(R.string.common_error)
                    val message = error?.presentationData?.message
                        ?: getString(R.string.error_message_unknown)
                    Triple(error?.details ?: UNKNOWN, message, title)
                }
            }
        }
        is SocketTimeoutException -> Triple(
            TIMEOUT,
            getString(R.string.error_message_timeout),
            getString(R.string.error_title_connect)
        )
        is ConnectException, is NoRouteToHostException, is UnknownHostException -> Triple(
            NO_CONNECTION,
            getString(R.string.error_message_connect),
            getString(R.string.error_title_connect)
        )
        is MalformedJsonException -> Triple(
            TYPE_MALFORMED_JSON,
            getString(R.string.error_message_malformed_json),
            getString(R.string.common_error)
        )
        else -> Triple(
            UNKNOWN,
            getString(R.string.error_message_unknown),
            getString(R.string.common_error)
        )
    }
}

/**
 * Получает детальную причину ошибки из JSON
 * @param errorJSON - входящий JSON
 * @return - локализованная причина ошибки
 */
fun getErrorType(errorJSON: String): ErrorResponse? {
    var errorResponse: ErrorResponse? = null
    try {
        val json = JSONObject(errorJSON)
        val errors = json.getJSONArray("errors")
        val error = errors.getJSONObject(0)
        val presentationData = error.getJSONObject("presentationData")

        errorResponse = ErrorResponse(
            error.getString("domain"),
            error.getString("details", UNKNOWN),
            PresentationData(
                presentationData.getString("title", getString(R.string.common_error)),
                presentationData.getString("message", getString(R.string.error_message_unknown))
            )
        )
    } catch (e: JSONException) {
    }
    return errorResponse
}

fun JSONObject.getString(key: String, def: String): String {
    val result = optString(key)
    return when {
        result.isBlank() -> def
        else -> result
    }
}