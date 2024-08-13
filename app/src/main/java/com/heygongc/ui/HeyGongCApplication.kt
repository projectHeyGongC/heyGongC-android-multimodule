package com.heygongc.ui

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class HeyGongCApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}