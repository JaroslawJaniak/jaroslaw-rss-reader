package pl.mobileappacademy.rssreader.presentation.fragments.RSSFragments

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_channel.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.data.models.rssModels.Item

class ChannelAdapter : BaseRecyclerAdapter<Item, ChannelAdapter.ChannelViewHolder>(){

    fun updateData(newData: List<Item>) {
        val data = arrayListOf<Item>()
        data.addAll(items)
        data.addAll(newData)

        this.items = data
        notifyDataSetChanged()
    }

    fun filterItems(selectedCategory: String, data: List<Item>) {
        //val data = arrayListOf<Item>()
        val filteredData = arrayListOf<Item>()
        //data.addAll(items)
        //data.addAll(newData)

        var x = selectedCategory

        data.forEach {
            if(it.category == selectedCategory){
                filteredData.add(it)
            }
        }

        this.items = filteredData
        notifyDataSetChanged()
    }


    override fun onBindViewHolder(holder: ChannelViewHolder, item: Item, position: Int) {

        holder.apply {
            itemView.item_channel_title.text = item.title
            itemView.item_channel_pubDate.text = item.pubDate
            itemView.item_channel_category.text = item.category
            itemView.item_channel_portal_name.text = item.portalName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelViewHolder {
        return ChannelViewHolder(parent.inflate(R.layout.item_channel))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ChannelViewHolder(view: View) : RecyclerView.ViewHolder(view)
}