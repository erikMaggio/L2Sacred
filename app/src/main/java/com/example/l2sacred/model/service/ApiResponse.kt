package com.example.l2sacred.model.service

import java.io.Serializable

class ApiResponse<out T>(var status: Status, val data: T?, val message: String) : Serializable {

    companion object {
        fun <T> create(code: Int, data: T?, message: String?): ApiResponse<T> {
            return ApiResponse(
                status = getStatusByCode(code),
                data = data,
                message = message ?: getMessageByCode(code)
            )
        }

        private fun getStatusByCode(code: Int): Status {
            return when (code) {
                in 200..300 -> {
                    Status.SUCCESS
                }

                in 301..404 -> {
                    Status.ERROR_QUERY
                }

                in 403..499 -> {
                    Status.ERROR_AUTH
                }

                in 500..600 -> {
                    Status.ERROR_SERVER
                }

                0 -> {
                    Status.ERROR_TIME_OUT
                }

                else -> {
                    Status.ERROR_GENERIC
                }
            }
        }

        private fun getMessageByCode(code: Int): String {
            return when (code) {
                in 200..300 -> {
                    "success"
                }

                in 301..404 -> {
                    "error in query"
                }

                in 403..499 -> {
                    "error identification"
                }

                in 500..600 -> {
                    "ups error - server disconnect"
                }

                0 -> {
                    "time out"
                }

                else -> {
                    "generic error"
                }
            }
        }

        enum class Status {
            SUCCESS, ERROR_QUERY, ERROR_AUTH, ERROR_TIME_OUT, ERROR_SERVER, ERROR_GENERIC
        }
    }
}