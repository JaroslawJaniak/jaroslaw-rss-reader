package pl.mobileappacademy.rssreader.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_channels.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.data.models.HomeListItem

class RssChannelsAdapter: BaseRecyclerAdapter<HomeListItem, RssChannelsAdapter.RssChannelsViewHolder>() {
    override var items: List<HomeListItem> = emptyList()

    override fun onBindViewHolder(holder: RssChannelsViewHolder, item: HomeListItem, position: Int) {
        holder.apply {

            itemView.item_list_rss_name.text = item.name

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RssChannelsViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rss_channels, viewGroup, false)
        return RssChannelsViewHolder(itemView)
    }

    class RssChannelsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}