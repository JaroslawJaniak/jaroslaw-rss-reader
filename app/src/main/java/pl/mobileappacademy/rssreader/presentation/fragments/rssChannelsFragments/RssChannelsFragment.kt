package pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments


import android.os.AsyncTask
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
import kotlinx.android.synthetic.main.add_dialog_spinner.view.*
import kotlinx.android.synthetic.main.rss_channels_fragment.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseFragment
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.OnItemClickListener
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.addOnItemClickListener

import pl.mobileappacademy.rssreader.presentation.fragments.adapters.RssChannelsAdapter
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.data.models.HomeListItem

class RssChannelsFragment : BaseFragment(), BottomBar.AppBottomBarListener {

    override fun onHomeClick() {

    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {

    }

    var url: String = ""
    private lateinit var itemToInsert: HomeListItem

    private lateinit var viewModel: RssChannelsViewModel
    private val rssChannelsAdapter by lazy { RssChannelsAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rss_channels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RssChannelsViewModel::class.java)

        viewModel.appDb?.channelsRssDao()?.getAllChannelsRss()?.observe(this, Observer {
            rssChannelsAdapter.items = it ?: emptyList()
            rssChannelsAdapter.notifyDataSetChanged()
        })

        rss_channels_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = rssChannelsAdapter
        }

        bottomBar?.setBottomBarListener(this)
        setLsteners()

    }

    private fun setLsteners() {
        rss_channels_recycle_view.addOnItemClickListener(object :
            OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                findNavController().navigate(R.id.channelFragment)
            }
        })
    }

    private fun showAddDialog() {

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_dialog_spinner, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle("Dodaj kanał")

        }
        val mAlertDialog = mBuilder?.show()

        mDialogView.add_dialog_OkBtn.setOnClickListener {

            val url: String = mDialogView.add_dialogAdressURL.text.toString()
            val name = mDialogView.spinner.selectedItem.toString()

            itemToInsert = HomeListItem()
            itemToInsert.name = name
            itemToInsert.adress = url

            AsyncTask.execute {
                viewModel.appDb?.channelsRssDao()?.insertChannelsRss(itemToInsert)
            }

            mAlertDialog?.dismiss()
        }

        mDialogView.add_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }
}
