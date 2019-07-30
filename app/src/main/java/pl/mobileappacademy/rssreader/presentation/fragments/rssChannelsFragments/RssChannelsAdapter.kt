package pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_channels.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.data.models.Portal

class RssChannelsAdapter: BaseRecyclerAdapter<Portal, RssChannelsAdapter.RssChannelsViewHolder>() {
    override var items: List<Portal> = emptyList()

    fun updateData(newData: List<Portal>) {
        val data = arrayListOf<Portal>()
        data.addAll(items)
        data.addAll(newData)

        this.items = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: RssChannelsViewHolder, item: Portal, position: Int) {
        holder.apply {

            itemView.item_list_rss_address.text = item.adress
            itemView.item_list_rss_name.text = item.name
            itemView.item_list_rss_portalName.text = item.portalName

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RssChannelsViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rss_channels, viewGroup, false)
        return RssChannelsViewHolder(
            itemView
        )
    }

    class RssChannelsViewHolder(view: View) : RecyclerView.ViewHolder(view)
}