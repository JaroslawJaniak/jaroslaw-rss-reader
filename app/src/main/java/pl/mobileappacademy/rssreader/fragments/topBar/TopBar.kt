package pl.mobileappacademy.rssreader.fragments.topBar

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.topbar_view.view.*
import pl.mobileappacademy.rssreader.R

class TopBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet?=null,defStyleAttr :Int =0
):RelativeLayout(context,attrs,defStyleAttr)
{

    private lateinit var  appTopBarListener:AppTopBarListener

    init {
        init(context)

    }
    private fun init(context: Context)
    {
        View.inflate(context, R.layout.topbar_view,this)
        setListeners()
    }

    fun setTopBarTitle(title:String)
    {
        textViewTopBar.text=title
    }

    fun setTopBarListener(topBarListener:AppTopBarListener)
    {
        this.appTopBarListener=topBarListener
    }

    private fun setListeners()
    {

    }

    interface AppTopBarListener{
        fun onBackClick()
    }
}