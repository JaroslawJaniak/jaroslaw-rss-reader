package pl.mobileappacademy.rssreader.presentation.fragments.channelDetails

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_channel.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.data.models.rssModels.Channel

class ChannelDetailsAdapter : BaseRecyclerAdapter<Channel, ChannelDetailsAdapter.ChannelDetailesViewHolder>(){

    override fun onBindViewHolder(holder: ChannelDetailesViewHolder, item: Channel, position: Int) {
        holder.apply {

            itemView.item_channel_title.text = item.title
            itemView.item_channel_pubDate.text = item.description
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChannelDetailesViewHolder {
        return ChannelDetailesViewHolder(
            parent.inflate(R.layout.item_channel)
        )
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun updateDataChannel(newData: List<Channel>) {
        val data = arrayListOf<Channel>()
        data.addAll(items)
        data.addAll(newData)

        this.items = data
        notifyDataSetChanged()
    }


    class ChannelDetailesViewHolder(view: View) : RecyclerView.ViewHolder(view)
}