package com.example.katmory.common.app

import android.app.Application
import com.example.katmory.data.datasource.SharedPreferenceManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidApp : Application() {
    @Inject
    lateinit var sharedPreferenceManager: SharedPreferenceManager
}