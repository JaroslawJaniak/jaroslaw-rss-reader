package pl.mobileappacademy.rssreader.fragments.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import kotlinx.android.synthetic.main.item_portal.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.fragments.New_Fragments.HomeItem

class HomeAdapter : BaseRecyclerAdapter<HomeItem, HomeAdapter.HomeViewHolder>() {
    override var items: List<HomeItem> = emptyList()
    override fun onBindViewHolder(holder: HomeViewHolder, item: HomeItem, position: Int) {


        holder.apply {
            if (item.imagePath != null) {
                Glide.with(itemView.context)
                    .load(item.imagePath)
                    .centerCrop()
                    .transform(RoundedCorners(5))
                    .into(itemView.item_portal_image)
            }

            itemView.item_portal_name.text = item.name
            itemView.item_portal_URL.text = item.imagePath
        }

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HomeViewHolder {
        val itemView = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_portal, viewGroup, false)
        return HomeViewHolder(itemView)
    }

    class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view)
}

