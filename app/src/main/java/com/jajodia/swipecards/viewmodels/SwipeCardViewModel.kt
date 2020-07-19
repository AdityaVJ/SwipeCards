package com.jajodia.swipecards.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.jajodia.swipecards.api.ApiService
import com.jajodia.swipecards.api.WebService
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SwipeCardViewModel() : ViewModel() {

    private val webservice = WebService.apiService

    fun loadData() {

        webservice.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("TAG", it.toString())
            }, {
                Log.e("ERROR", it.message.toString())
            })

    }

}