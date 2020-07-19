package com.jajodia.swipecards.api

import com.jajodia.swipecards.models.ApiResponseModel
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("fjaqJ")
    fun getData(): Observable<ApiResponseModel>
}