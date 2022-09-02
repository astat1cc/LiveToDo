package com.github.astat1cc.livetodo.core

import retrofit2.HttpException
import java.net.UnknownHostException

interface ExceptionHandler {

    fun defineErrorTypeOfException(e: Exception): ErrorType

    class Impl: ExceptionHandler {

        override fun defineErrorTypeOfException(e: Exception): ErrorType =
            when (e) {
                is UnknownHostException -> ErrorType.NO_CONNECTION
                is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                else -> ErrorType.GENERIC_EXCEPTION
            }
    }
}