package pl.mobileappacademy.rssreader.fragments.RSSFragments

import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_channel.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.models.rssModels.Item

class ChannelAdapter : BaseRecyclerAdapter<Item, ChannelAdapter.ChannelViewHolder>(){

    fun updateData(newData: List<Item>) {
        val data = arrayListOf<Item>()
        data.addAll(items)
        data.addAll(newData)

        this.items = data
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ChannelViewHolder, item: Item, position: Int) {

        holder.apply {

            itemView.item_channel_title.text = item.title
            itemView.item_channel_pubDate.text = item.pubDate
            itemView.item_channel_category.text = item.category
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