package pl.mobileappacademy.rssreader.fragments.RSSFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.channel_fragment.*
import kotlinx.android.synthetic.main.channel_fragment.channel_recycle_view
import pl.mobileappacademy.rssreader.Injector

import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsViewModel
import pl.mobileappacademy.rssreader.fragments.adapters.RssChannelsAdapter
import pl.mobileappacademy.rssreader.fragments.dialogs.DialogFilterFragment
import pl.mobileappacademy.rssreader.models.HomeListItem

class ChannelFragment : BaseFragment() {

    private lateinit var viewModel: ChannelViewModel
    private val channelAdapter by lazy { ChannelAdapter() }
    private val homeListAdapter by lazy { RssChannelsAdapter() }


    private lateinit var viewHomeList: List<HomeListItem>
    var url: String? = ""

    companion object {
        fun newInstance() = ChannelFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        Injector.component.inject(this)

        return inflater.inflate(R.layout.channel_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChannelViewModel::class.java)

        val dialog = DialogFilterFragment()

        channel_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = channelAdapter
        }

        viewHomeList = RssChannelsViewModel().getHomeListViewTVN()
        for (i in viewHomeList) {
            url = i.adress
            viewModel.fetchData2(url, i.name ?: "")
        }

        viewModel.itemsChannelList.observe(this, Observer {
            channelAdapter.updateData(it ?: emptyList())
            channelAdapter.notifyDataSetChanged()
        })

        channel_filtr_button.setOnClickListener {
            //findNavController().navigate(R.id.dialogFilterFragment)

            dialog.show(fragmentManager, "DialogFilterFragment")

        }
    }
}
