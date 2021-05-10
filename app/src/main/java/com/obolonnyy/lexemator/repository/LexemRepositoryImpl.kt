package com.obolonnyy.lexemator.repository

import android.content.Context
import com.google.gson.Gson
import com.obolonnyy.lexemator.App
import com.obolonnyy.lexemator.di.NetworkModule
import java.io.IOException


interface LexemRepository {
    suspend fun getLatestStrings(): Map<String, String>
}

class LexemRepositoryImpl(
    private val context: Context = App.context,
    private val gson: Gson = NetworkModule.gson,
) : LexemRepository {

    override suspend fun getLatestStrings(): Map<String, String> {
        // replace with api call if needed
        return if (true) {
            getMockStrings()
        } else {
            // api.getServerStrings()
            error("")
        }
    }

    private fun getMockStrings(): Map<String, String> {
        return getModel("server_strings")
    }

    private inline fun <reified DtoT> getModel(filename: String): DtoT {
        val content = getAssetMockFileContent(filename)
        return gson.fromJson(content, DtoT::class.java)
    }

    private fun getAssetMockFileContent(filename: String): String? = try {
        val inputStream = context.assets.open("json/$filename.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.use { it.read(buffer) }
        String(buffer)
    } catch (ioException: IOException) {
        ioException.printStackTrace()
        null
    }
}