package com.github.astat1cc.livetodo

import android.app.Application
import com.github.astat1cc.livetodo.core.coreModule
import com.github.astat1cc.livetodo.core.di.retrofitModule
import com.github.astat1cc.livetodo.feature_todolist.di.featureToDoListModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(retrofitModule, featureToDoListModule, coreModule)
        }
    }
}