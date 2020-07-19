package com.jajodia.swipecards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jajodia.swipecards.R
import com.jajodia.swipecards.adapters.CardAdapter
import com.jajodia.swipecards.viewmodels.SwipeCardViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(SwipeCardViewModel::class.java) }

    private lateinit var cardAdapter: CardAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cardAdapter = CardAdapter(this)
        card_viewpager.adapter = cardAdapter

        viewModel.observeData().observe(this, Observer {
            cardAdapter.setCardData(it.data)
        })

        viewModel.loadData()
    }
}