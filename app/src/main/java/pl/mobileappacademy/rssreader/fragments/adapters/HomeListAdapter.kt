package pl.mobileappacademy.rssreader.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list_rss.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.models.HomeListItem

class HomeListAdapter: BaseRecyclerAdapter<HomeListItem, HomeListAdapter.HomeListViewHolder>() {
    override var items: List<HomeListItem> = emptyList()

    override fun onBindViewHolder(holder: HomeListViewHolder, item: HomeListItem, position: Int) {
        holder.apply {

            itemView.item_list_rss_name.text = item.name
            itemView.item_list_rss_address.text = item.adress
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): HomeListViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_list_rss, viewGroup, false)
        return HomeListViewHolder(itemView)
    }

    class HomeListViewHolder(view: View) : RecyclerView.ViewHolder(view)

}