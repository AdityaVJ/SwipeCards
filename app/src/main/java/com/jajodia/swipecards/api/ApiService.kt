package com.jajodia.swipecards.api

import com.jajodia.swipecards.models.ApiResponseModel
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET

interface ApiService {

    @GET("fjaqJ")
    fun getData(): Observable<ApiResponseModel>

}