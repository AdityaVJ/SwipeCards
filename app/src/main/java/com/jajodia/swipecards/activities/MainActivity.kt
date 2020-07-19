package com.jajodia.swipecards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.jajodia.swipecards.R
import com.jajodia.swipecards.viewmodels.SwipeCardViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(SwipeCardViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.loadData()
    }
}