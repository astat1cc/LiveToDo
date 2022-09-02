package com.github.astat1cc.livetodo.core

import android.content.Context
import androidx.annotation.StringRes

interface ResourceProvider {

    fun getString(@StringRes id: Int): String

    fun getString(@StringRes id: Int, arg: String): String

    class Impl(private val context: Context) : ResourceProvider {

        override fun getString(id: Int): String = context.getString(id)

        override fun getString(id: Int, arg: String) = context.getString(id, arg)
    }
}