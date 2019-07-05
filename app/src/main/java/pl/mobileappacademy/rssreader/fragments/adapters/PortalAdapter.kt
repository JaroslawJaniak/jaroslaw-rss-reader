package pl.mobileappacademy.rssreader.fragments.adapters



//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_portal.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.models.Portal

class PortalAdapter(private val dataList:List<Portal>?) : RecyclerView.Adapter<PortalAdapter.PostViewHolder>()
{
    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PostViewHolder {
        val itemView=LayoutInflater.from(viewGroup.context).inflate(R.layout.item_portal,viewGroup,false)

        return PostViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return dataList?.size ?: 0
    }

    override fun onBindViewHolder(postViewHolder: PostViewHolder, position: Int) {
        val item=dataList?.get(position)

        // ??? -> portalViewHolder.itemView.portal_textView1.text="aaaaaa"
        postViewHolder.itemView.portal_textView2.text="bbbbbb"
    }


    inner class PostViewHolder internal  constructor(view: View) :RecyclerView.ViewHolder(view)

}