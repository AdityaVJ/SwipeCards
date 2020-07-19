package com.jajodia.swipecards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jajodia.swipecards.R

class MainActivity : AppCompatActivity() {

//    private val viewModel by lazy { ViewModelProvider(this).get() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}