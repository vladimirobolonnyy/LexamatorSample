package com.obolonnyy.lexemator.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object NetworkModule {
    val gson: Gson = GsonBuilder().create()
}