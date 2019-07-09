package pl.mobileappacademy.rssreader.fragments.OldFrgments


//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_portal.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.models.Portal

class PortalAdapter() : BaseRecyclerAdapter<Portal, PortalAdapter.PortalViewHolder>() {
    override fun onBindViewHolder(holder: PortalViewHolder, item: Portal, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        val item = items[position]
        holder.itemView.item_portal_name.text = item.name
        holder.itemView.item_portal_name.text = item.imageUrl
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): PortalViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_portal, viewGroup, false)

        return PortalViewHolder(itemView)
    }

    inner class PortalViewHolder internal constructor(view: View) : RecyclerView.ViewHolder(view)

}

