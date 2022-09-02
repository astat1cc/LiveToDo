package com.github.astat1cc.livetodo.core

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val coreModule = module {
    single<ResourceProvider> {
        ResourceProvider.Impl(androidContext())
    }
}