package com.jajodia.swipecards.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.jajodia.swipecards.R
import com.jajodia.swipecards.models.DataModel
import kotlinx.android.synthetic.main.swipable_card.view.*

class CardAdapter(private val context: Context) :
    PagerAdapter() {

    private var list: List<DataModel>? = listOf()
    private lateinit var layoutInflater: LayoutInflater

    fun setCardData(list: List<DataModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = LayoutInflater.from(context)
        val view = layoutInflater.inflate(R.layout.swipable_card, container, false)

        list?.let {
            val item = it[position]
            view.card_text.text = item.text
        }

        container.addView(view, 0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun getCount(): Int {
        return list?.size ?: 0
    }
}
