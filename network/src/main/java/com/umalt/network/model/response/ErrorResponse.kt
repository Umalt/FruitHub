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
const val UNAUTHORIZED = "UNAUTHORIZED"
const val NO_CONNECTION = "NO_CONNECTION"
const val TYPE_MALFORMED_JSON = "TYPE_MALFORMED_JSON"
const val PAGE_NOT_FOUND = "PAGE_NOT_FOUND"
const val SERVER_UNAVAILABLE = "SERVER_UNAVAILABLE"
const val INTERNAL_SERVER = "INTERNAL_SERVER"
const val EXPIRED_TOKEN = "EXPIRED_TOKEN"
const val NOT_EXIST = "NOT_EXIST"
const val USER_NOT_EXIST = "USER_NOT_EXIST"
const val UNSUCCESSFUL_REFRESH = "UNSUCCESSFUL_REFRESH"
const val OUTDATED_VERSION = "OUTDATED_VERSION"
const val ACCOUNT_IS_BLOCKED = "ACCOUNT_IS_BLOCKED"
const val INVALID_TOKEN_FORMAT = "INVALID_TOKEN_FORMAT"
const val INCOMPATIBLE_STATUS = "INCOMPATIBLE_STATUS"

class ErrorResponse(
    val domain: String?,
    val details: String?,
    val presentationData: PresentationData?
)

class PresentationData(
    val title: String?,
    val message: String?
)