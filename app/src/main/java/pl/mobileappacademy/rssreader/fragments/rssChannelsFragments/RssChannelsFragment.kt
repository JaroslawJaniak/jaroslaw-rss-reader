package pl.mobileappacademy.rssreader.fragments.rssChannelsFragments


import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rss_channels_fragment.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.base.OnItemClickListener
import pl.mobileappacademy.rssreader.base.addOnItemClickListener

import pl.mobileappacademy.rssreader.fragments.adapters.RssChannelsAdapter

class RssChannelsFragment : BaseFragment() {

    var url: String = ""

    private lateinit var viewModel: RssChannelsViewModel
    private val homeListAdapter by lazy { RssChannelsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rss_channels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RssChannelsViewModel::class.java)

        viewModel.appDb?.portalDao()?.getAllRss()?.observe(this, Observer {
            homeListAdapter.items = it ?: emptyList()
            homeListAdapter.notifyDataSetChanged()
        })

        rss_channels_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = homeListAdapter
        }

        setLsteners()
    }

    private fun setLsteners() {
        rss_channels_recycle_view.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                url = homeListAdapter.items[position].adress.toString()
                findNavController().navigate(R.id.channelFragment)

            }
        })
    }
}
