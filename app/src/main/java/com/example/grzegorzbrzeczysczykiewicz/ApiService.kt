package com.example.grzegorzbrzeczysczykiewicz

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://swapi.dev/api/"
private const val QUERY_STRING_1 = "people/?page=1"
private const val QUERY_STRING_2 = "people/?page=2"
private const val QUERY_STRING_3 = "people/?page=3"
private const val QUERY_STRING_4 = "people/?page=4"
private const val QUERY_STRING_5 = "people/?page=5"
private const val QUERY_STRING_6 = "people/?page=6"
private const val QUERY_STRING_7 = "people/?page=7"
private const val QUERY_STRING_8 = "people/?page=8"
private const val QUERY_STRING_9 = "people/?page=9"




private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
private val retrofit = Retrofit.Builder().addConverterFactory(MoshiConverterFactory.create(moshi)).baseUrl(BASE_URL).build()

interface ApiService {

    @GET(QUERY_STRING_1)
    fun getGuessers1(): Call<ApiResponse>

    @GET(QUERY_STRING_2)
    fun getGuessers2(): Call<ApiResponse>

    @GET(QUERY_STRING_3)
    fun getGuessers3(): Call<ApiResponse>

    @GET(QUERY_STRING_4)
    fun getGuessers4(): Call<ApiResponse>

    @GET(QUERY_STRING_5)
    fun getGuessers5(): Call<ApiResponse>

    @GET(QUERY_STRING_6)
    fun getGuessers6(): Call<ApiResponse>

    @GET(QUERY_STRING_7)
    fun getGuessers7(): Call<ApiResponse>

    @GET(QUERY_STRING_8)
    fun getGuessers8(): Call<ApiResponse>

    @GET(QUERY_STRING_9)
    fun getGuessers9(): Call<ApiResponse>
}

object SWAPI {
    val swapi: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}