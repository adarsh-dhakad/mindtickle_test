package com.adarsh.mindtickletest

import android.app.Application
import com.adarsh.mindtickletest.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MindTickleApp : Application(){
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MindTickleApp)
            modules( listOf(appModule))
        }
    }
}