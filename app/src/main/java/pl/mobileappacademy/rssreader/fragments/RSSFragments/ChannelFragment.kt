package pl.mobileappacademy.rssreader.fragments.RSSFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.channel_fragment.*
import pl.mobileappacademy.rssreader.Injector

import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.di.modules.RestModule
import pl.mobileappacademy.rssreader.models.HomeListItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ChannelFragment : BaseFragment() {

    private lateinit var viewModel: ChannelViewModel
    private val channelAdapter by lazy { ChannelAdapter() }

    companion object {
        fun newInstance() = ChannelFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Injector.component.inject(this)

        return inflater.inflate(R.layout.channel_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChannelViewModel::class.java)

        channel_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = channelAdapter
        }

        viewModel.fetchData()
        viewModel.fetchData2("aaaaa")

        viewModel.itemsChannelList.observe(this, Observer {
            channelAdapter.items = it ?: emptyList()
            channelAdapter.notifyDataSetChanged()
        })
    }
}
