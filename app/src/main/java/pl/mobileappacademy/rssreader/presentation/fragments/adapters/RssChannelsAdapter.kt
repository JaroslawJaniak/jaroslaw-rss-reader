package pl.mobileappacademy.rssreader.presentation.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_rss_channels.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.data.models.HomeListItem
import pl.mobileappacademy.rssreader.data.models.rssModels.Item

class RssChannelsAdapter: BaseRecyclerAdapter<HomeListItem, RssChannelsAdapter.RssChannelsViewHolder>() {
    override var items: List<HomeListItem> = emptyList()

    fun updateData(newData: List<HomeListItem>) {
        val data = arrayListOf<HomeListItem>()
        data.addAll(items)
        data.addAll(newData)

        this.items = data
        notifyDataSetChanged()
    }

    fun initFilterItems(portalName: String?, data: List<HomeListItem>) {
        val filteredData = arrayListOf<HomeListItem>()

        data.forEach {
            if(it.portalName == portalName){
                filteredData.add(it)
            }
        }

        this.items = filteredData
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: RssChannelsViewHolder, item: HomeListItem, position: Int) {
        holder.apply {

            itemView.item_list_rss_address.text = item.adress
            itemView.item_list_rss_name.text = item.name
            itemView.item_list_rss_portalName.text = item.portalName

        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RssChannelsViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_rss_channels, viewGroup, false)
        return RssChannelsViewHolder(itemView)
    }

    class RssChannelsViewHolder(view: View) : RecyclerView.ViewHolder(view)

}