package pl.mobileappacademy.rssreader.fragments.RSSFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.channel_detailes_fragment.*
import kotlinx.android.synthetic.main.channel_fragment.*

import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsViewModel

class ChannelDetailesFragment : BaseFragment() {

    companion object {
        fun newInstance() = ChannelDetailesFragment()
    }

    private lateinit var viewModel: ChannelDetailesViewModel
    private val channelDetailesAdapter by lazy { ChannelDetailsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.channel_detailes_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChannelDetailesViewModel::class.java)

        channel_detailes_recycler_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = channelDetailesAdapter
        }

        var viewHomeList = RssChannelsViewModel().getHomeListView()

        for (i in viewHomeList) {
            val url = i.adress
            viewModel.fetchData(url)
        }

        viewModel.channelDetailes.observe(this, Observer {
            channelDetailesAdapter.updateDataChannel(it ?: emptyList())
            channelDetailesAdapter.notifyDataSetChanged()
        })

    }

}
