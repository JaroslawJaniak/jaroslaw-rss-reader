package pl.mobileappacademy.rssreader.fragments.dialogs

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
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

class DialogFilterFragment : DialogFragment() {

    private lateinit var viewModel: DialogFilterViewModel

    private val rssChannelsAdapter by lazy { RssChannelsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.dialog_filter_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(DialogFilterViewModel::class.java)

        viewModel.appDb?.portalDao()?.getAllRss()?.observe(this, Observer {
            rssChannelsAdapter.items = it ?: emptyList()
            rssChannelsAdapter.notifyDataSetChanged()
        })

        rss_channels_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = rssChannelsAdapter
        }

    }
}
