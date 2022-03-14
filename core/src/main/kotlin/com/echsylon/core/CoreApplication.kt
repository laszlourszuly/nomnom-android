package com.echsylon.core

import android.app.Application
import android.util.Log
import com.echsylon.core.BuildConfig.DEBUG
import timber.log.Timber
import timber.log.Timber.DebugTree

open class CoreApplication : Application() {
    private class ProdTree : Timber.Tree() {
        override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
            when (priority) {
                Log.WARN -> Unit    // Implement production worthy logging here
                Log.ERROR -> Unit   // Implement production worthy logging here
                Log.DEBUG -> Unit   // Don't log debug messages for production
                Log.VERBOSE -> Unit // Don't log verbose messages for production
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (DEBUG) Timber.plant(DebugTree())
        else Timber.plant(ProdTree())
    }
}