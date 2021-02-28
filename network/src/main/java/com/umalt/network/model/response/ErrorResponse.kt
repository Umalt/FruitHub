package com.umalt.network.model.response

/**
 * Created by Umalt on 2/22/21
 */
// Domain
//const val USER = "USER"
//const val AUTH = "AUTH"
//const val DELIVERY = "DELIVERY"

// ErrorDetails
const val UNKNOWN = "UNKNOWN"
const val TIMEOUT = "TIMEOUT"
const val NO_CONNECTION = "NO_CONNECTION"
const val TYPE_MALFORMED_JSON = "TYPE_MALFORMED_JSON"
const val PAGE_NOT_FOUND = "PAGE_NOT_FOUND"
const val SERVER_UNAVAILABLE = "SERVER_UNAVAILABLE"
const val INTERNAL_SERVER = "INTERNAL_SERVER"

class ErrorResponse(
    val domain: String?,
    val details: String?,
    val presentationData: PresentationData?
)

class PresentationData(
    val title: String?,
    val message: String?
)