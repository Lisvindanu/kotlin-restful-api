package vin.smoke.id.kotlin.restful.api.model

data class WebResponse<T>(val code: Int,
                       val status: String,
    val data: T)