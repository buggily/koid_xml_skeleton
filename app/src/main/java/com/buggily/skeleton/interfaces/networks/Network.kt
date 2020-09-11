package com.buggily.skeleton.interfaces.networks

import com.buggily.skeleton.BuildConfig
import com.buggily.skeleton.Constants
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit

@ExperimentalSerializationApi
interface Network<T : Apiable> {

    val api: T
    val baseUrl: String

    val retrofit: Retrofit
        get() = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(converterFactory)
            .build()

    private val client: OkHttpClient
        get() = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

    private val interceptor: HttpLoggingInterceptor
        get() = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    private val converterFactory: Converter.Factory
        get() = Json.asConverterFactory(Constants.Media.Type.APPLICATION_JSON)
}