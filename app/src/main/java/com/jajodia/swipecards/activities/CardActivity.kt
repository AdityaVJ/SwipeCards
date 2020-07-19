package com.jajodia.swipecards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.jajodia.swipecards.R
import com.jajodia.swipecards.adapters.CardAdapter
import com.jajodia.swipecards.models.DataModel
import com.jajodia.swipecards.viewmodels.SwipeCardViewModel
import kotlinx.android.synthetic.main.activity_card.*

class CardActivity : AppCompatActivity() {

    private val viewModel by lazy { ViewModelProvider(this).get(SwipeCardViewModel::class.java) }

    private lateinit var cardAdapter: CardAdapter
    private var cardItemsList: List<DataModel> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        cardAdapter = CardAdapter(this)
        card_viewpager.adapter = cardAdapter

        progress_text.text = String.format(getString(R.string.progress_text), "10%")

        card_viewpager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                Log.e("Page selected", position.toString())
            }

        })

        viewModel.observeData().observe(this, Observer {
            cardItemsList = it.data
            cardAdapter.setCardData(cardItemsList)
        })

        viewModel.loadData()
    }
}