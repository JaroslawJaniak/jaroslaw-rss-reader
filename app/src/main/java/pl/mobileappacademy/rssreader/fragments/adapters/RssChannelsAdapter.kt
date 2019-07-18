package pl.mobileappacademy.rssreader.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_channels.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.models.HomeListItem

class RssChannelsAdapter: BaseRecyclerAdapter<HomeListItem, RssChannelsAdapter.HomeListViewHolder>() {
    override var items: List<HomeListItem> = emptyList()

    override fun onBindViewHolder(holder: HomeListViewHolder, item: HomeListItem, position: Int) {
        holder.apply {

            itemView.item_list_rss_name.text = item.name

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeListViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rss_channels, viewGroup, false)
        return HomeListViewHolder(itemView)
    }

    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view)

}