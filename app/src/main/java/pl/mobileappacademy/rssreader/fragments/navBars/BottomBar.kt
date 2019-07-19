package pl.mobileappacademy.rssreader.fragments.navBars

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.bottom_bar_view.view.*
import kotlinx.android.synthetic.main.topbar_view.view.*
import pl.mobileappacademy.rssreader.R

class BottomBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {

    private lateinit var appBottomBarListener: AppBottomBarListener

    init {
        View.inflate(context, R.layout.bottom_bar_view, this)
        setListeners()

    }

    fun setBottomBarListener(bottomBarListener: AppBottomBarListener) {
        this.appBottomBarListener = bottomBarListener
    }

    private fun setListeners() {
        bottom_bar_home.setOnClickListener { appBottomBarListener.onHomeClick()}
        bottom_bar_add.setOnClickListener { appBottomBarListener.onAddClick()}
        bottom_bar_sort.setOnClickListener { appBottomBarListener.onSortClick()}
    }

    interface AppBottomBarListener {
        fun onHomeClick()
        fun onAddClick()
        fun onSortClick()
    }
}