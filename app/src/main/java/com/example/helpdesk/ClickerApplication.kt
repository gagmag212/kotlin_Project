package com.example.helpdesk

import android.app.Application
import timber.log.Timber

class ClickerApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }

}