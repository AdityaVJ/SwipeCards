package com.jajodia.swipecards.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jajodia.swipecards.api.WebService
import com.jajodia.swipecards.models.ApiResponseModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class SwipeCardViewModel : ViewModel() {

    private val webservice = WebService.apiService
    private val apiData: MutableLiveData<ApiResponseModel> = MutableLiveData()

    fun observeData(): LiveData<ApiResponseModel> = apiData

    fun loadData() {

        webservice.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                apiData.postValue(it)
            }, {
                Log.e("ERROR", it.message.toString())
            })

    }

}