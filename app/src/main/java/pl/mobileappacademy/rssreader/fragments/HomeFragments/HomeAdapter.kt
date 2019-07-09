package pl.mobileappacademy.rssreader.fragments.adapters



//import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import kotlinx.android.synthetic.main.item_portal.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseRecyclerAdapter
import pl.mobileappacademy.rssreader.fragments.New_Fragments.HomeItem
import pl.mobileappacademy.rssreader.models.Portal

class HomeAdapter : BaseRecyclerAdapter<HomeItem, HomeAdapter.HomeViewHolder>()
{
    override var items: List<HomeItem> = emptyList()
    override fun onBindViewHolder(holder: HomeViewHolder, item: HomeItem, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

        val item = items[position]
        holder.itemView.item_portal_name.text = item.name
        holder.itemView.item_portal_name.text=item.imagePath

        /*
        holder.apply {
            if (item.info.posterPath != null) {
                GlideApp.with(itemView.context)
                    .load(Cfg.IMG_URL + movie.info.posterPath)
                    .transform(RoundedCorners(5))
                    .into(itemView.item_movielist_movie_image)
            }

            itemView.item_movielist_movie_title.text = movie.info.title
            itemView.item_movielist_movie_overview.text = movie.info.overview
            itemView.item_movielist_movie_rating.text =
                itemView.context.getString(R.string.rating_5, (movie.info.voteAverage).votesToHalf())
            itemView.item_movielist_movie_likes.text = movie.info.voteCount.toString()
            itemView.setOnClickListener {
                movieChosen(movie)
            }
        }
        */
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HomeViewHolder {
        val itemView=LayoutInflater.from(viewGroup.context).inflate(R.layout.item_portal,viewGroup,false)

        return HomeViewHolder(itemView)
    }

    inner class HomeViewHolder internal  constructor(view: View) :RecyclerView.ViewHolder(view)

}
