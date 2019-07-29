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
import pl.mobileappacademy.rssreader.data.models.rssModels.Item

class RssChannelsFragment : BaseFragment(), BottomBar.AppBottomBarListener {

    private var allItems = arrayListOf<HomeListItem>()
    private lateinit var viewHomeList: List<HomeListItem>
    private lateinit var itemToInsert: HomeListItem
    private var portalNameHome: String? = ""
    var isSortASC = false

    private lateinit var viewModel: RssChannelsViewModel
    private val rssChannelsAdapter by lazy { RssChannelsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            portalNameHome = it.getString("SERIVISE_FILTER")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.rss_channels_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RssChannelsViewModel::class.java)

        rss_channels_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = rssChannelsAdapter
        }

        viewHomeList = RssChannelsViewModel().getHomeListView()
        //initFiltrByPortalName(viewHomeList)

        viewModel.appDb?.channelsRssDao()?.getAllChannelsRss()?.observe(this, Observer {
            rssChannelsAdapter.items = it ?: emptyList()
            rssChannelsAdapter.notifyDataSetChanged()
        })

        viewModel.homeListItemlList.observe(this, Observer {
            allItems.addAll(it)
            rssChannelsAdapter.updateData(it ?: emptyList())
            rssChannelsAdapter.notifyDataSetChanged()
        })

        var x = viewHomeList[1].name

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

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_dialog_portal, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle(resources.getString(R.string.dodaj_kanal))

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

    fun initFiltrByPortalName(viewHomeList: List<HomeListItem>) {

    }

    override fun onHomeClick() {

    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {

    }
}
