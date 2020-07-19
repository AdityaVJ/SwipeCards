package com.jajodia.swipecards.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.jajodia.swipecards.R
import com.jajodia.swipecards.adapters.CardAdapter
import com.jajodia.swipecards.models.DataModel
import com.jajodia.swipecards.viewmodels.SwipeCardViewModel
import kotlinx.android.synthetic.main.activity_card.*
import kotlin.math.roundToInt

class CardActivity : AppCompatActivity(), ViewPager.OnPageChangeListener {

    private val viewModel by lazy { ViewModelProvider(this).get(SwipeCardViewModel::class.java) }

    private lateinit var cardAdapter: CardAdapter
    private var cardItemsList: List<DataModel> = listOf()
    private var listSize = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card)

        cardAdapter = CardAdapter(this)
        card_viewpager.adapter = cardAdapter

        card_viewpager.addOnPageChangeListener(this)

        viewModel.observeData().observe(this, Observer {
            cardItemsList = it.data
            cardAdapter.setCardData(cardItemsList)
            listSize = cardItemsList.size

            swipe_refresh.isRefreshing = false

            error_text.visibility = View.GONE
            cardButtonsVisibility(View.VISIBLE)
        })

        previous.setOnClickListener {
            card_viewpager.currentItem = card_viewpager.currentItem - 1
        }

        next.setOnClickListener {
            card_viewpager.currentItem = card_viewpager.currentItem + 1
        }

        refresh.setOnClickListener {
            card_viewpager.currentItem = 0
        }

        viewModel.observeError().observe(this, Observer {
            swipe_refresh.isRefreshing = false
            Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
            error_text.visibility = View.VISIBLE
            cardButtonsVisibility(View.GONE)
            previous.visibility = View.GONE
            progress_text.visibility = View.GONE
            progress.visibility = View.GONE
        })

        swipe_refresh.setOnRefreshListener {
            viewModel.loadData()
        }

        viewModel.loadData()
    }

    private fun cardButtonsVisibility(visibility: Int) {
        refresh.visibility = visibility
        next.visibility = visibility
    }

    override fun onPageScrollStateChanged(state: Int) {

    }

    override fun onPageScrolled(
        position: Int,
        positionOffset: Float,
        positionOffsetPixels: Int
    ) {

    }

    override fun onPageSelected(position: Int) {
        val p: Float = (position.toFloat() + 1) / listSize * 100

        if (position == 0)
            previous.visibility = View.GONE
        else
            previous.visibility = View.VISIBLE

        if (position == listSize - 1)
            next.visibility = View.GONE
        else
            next.visibility = View.VISIBLE


        progress_text.visibility = View.VISIBLE
        progress.visibility = View.VISIBLE

        progress.progress = p.roundToInt()
        progress_text.text =
            String.format(getString(R.string.progress_text), "$p%")
    }

}