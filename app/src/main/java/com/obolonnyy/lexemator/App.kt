package com.obolonnyy.lexemator

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import com.obolonnyy.lexemator.domain.UpdateStringsInteractor
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmStatic
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = this
        GlobalScope.launch(Dispatchers.IO) {
            async { UpdateStringsInteractor().invoke() }
        }
    }
}