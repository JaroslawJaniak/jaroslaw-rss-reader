package pl.mobileappacademy.rssreader.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView


abstract class BaseRecyclerAdapter<ITEM, VH: RecyclerView.ViewHolder> : RecyclerView.Adapter<VH> () {
    open var items: List<ITEM> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: VH, position: Int) {
        onBindViewHolder(holder, getItem(position), position)
    }

    abstract fun onBindViewHolder(holder: VH, item: ITEM, position: Int)

    override fun getItemCount() = items.size
    fun getItem(position: Int) = items[position]

    fun ViewGroup.inflate(@LayoutRes id: Int): View = LayoutInflater.from(this.context).inflate(id, this, false)
}