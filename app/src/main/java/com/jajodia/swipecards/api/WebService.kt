package com.jajodia.swipecards.api

import com.google.gson.GsonBuilder
import com.jajodia.swipecards.Constants
import okhttp3.*
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object WebService {

    private val httpClient: OkHttpClient = OkHttpClient
        .Builder()
        .connectTimeout(30, TimeUnit.SECONDS)
        .readTimeout(30, TimeUnit.SECONDS)
        .addInterceptor(NetworkInterceptor())
        .build()

    private val moshi = MoshiConverterFactory
        .create()
        .asLenient()

    private val gson = GsonBuilder()
        .setLenient()
        .create()


    private val retrofit: Retrofit = Retrofit
        .Builder()
        .client(httpClient)
        .baseUrl(Constants.API)
//        .addConverterFactory(moshi)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()

    val apiService: ApiService = retrofit.create(ApiService::class.java)
}
