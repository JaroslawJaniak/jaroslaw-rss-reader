package pl.mobileappacademy.rssreader.presentation.fragments.channelFragments

import android.os.AsyncTask
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_dialog.view.*
import kotlinx.android.synthetic.main.channel_fragment.*
import kotlinx.android.synthetic.main.channel_fragment.channel_recycle_view
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseFragment
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.data.models.Portal
import pl.mobileappacademy.rssreader.data.models.rssModels.Item
import pl.mobileappacademy.rssreader.presentation.activities.base.dialogs.DialogFilterFragment
import pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments.RssChannelsFragment as RssChannelsFragment

class ChannelFragment : BaseFragment(), BottomBar.AppBottomBarListener, DialogFilterFragment.DialogInterface {


    override fun categorySelected(category: String) {
        channelAdapter.filterItems(category, portalNameHome, allItems)
    }

    fun showDialog() {
        val dialog = DialogFilterFragment()
        dialog.setInterface(this)
        dialog.show(fragmentManager, "dialog")
    }

    private lateinit var itemToInsert: Portal
    private lateinit var viewModel: ChannelViewModel
    private lateinit var viewHomeList: List<Portal>
    private var allHomeListItems = arrayListOf<Portal>()
    private var allItems = arrayListOf<Item>()
    private var portalNameHome: String? = ""
    private var channelName: String? = ""
    var isSortASC = false

    private val channelAdapter by lazy { ChannelAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            portalNameHome = it.getString("SERVISE_FILTER")
            channelName = it.getString("SERVISE_CHANNEL")
        }
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

        channel_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = channelAdapter
        }

        if(channelName != null) {
            viewModel.appDb?.itemChannelXmlDao()?.getByPortalNameItemChannelXml(portalNameHome, channelName)
                ?.observe(this, Observer {
                    channelAdapter.items = it ?: emptyList()
                    channelAdapter.notifyDataSetChanged()
                })
        }
        else{
            viewModel.appDb?.itemChannelXmlDao()?.getAllByPortalNameItemChannelXml(portalNameHome)
                ?.observe(this, Observer {
                    channelAdapter.items = it ?: emptyList()
                    channelAdapter.notifyDataSetChanged()
                })
        }

        viewModel.itemsChannelList.observe(this, Observer {
            allItems.addAll(it)
            channelAdapter.updateData(it ?: emptyList())
            channelAdapter.notifyDataSetChanged()
        })

        viewModel.myDataFromDB?.observe(this, Observer {
            initFiltrByPortalName(it)
       })



        bottomBar?.setBottomBarListener(this)

        channel_filtr_button.setOnClickListener {
            showDialog()
        }
    }

    private fun showAddDialog() {
        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_dialog, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle(resources.getString(R.string.dodaj_kanal))

        }
        val mAlertDialog = mBuilder?.show()

        mDialogView.login_dialog_OkBtn.setOnClickListener {

            val url: String = mDialogView.login_dialogAdressURL.text.toString()
            val name: String = mDialogView.login_dialog_name.text.toString()
            val portalName: String = mDialogView.login_dialog_portalName.text.toString()

            itemToInsert = Portal()
            itemToInsert.adress = url
            itemToInsert.name = name
            itemToInsert.portalName = portalName


            AsyncTask.execute {
                viewModel.appDb?.channelsRssDao()?.insertChannelsRss(itemToInsert)
            }

            mAlertDialog?.dismiss()
        }

        mDialogView.login_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }

    override fun onHomeClick() {
        navigation?.navigate(R.id.homeFragment)
    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {
        if(!isSortASC){

            viewModel.appDb?.itemChannelXmlDao()?.sortByNameASCItemChannelXml(portalNameHome)?.observe(this, Observer {
                channelAdapter.items = it ?: emptyList()
                channelAdapter.notifyDataSetChanged()
            })

            isSortASC = true
        }
        else{
            viewModel.appDb?.itemChannelXmlDao()?.sortByNameDSCItemChannelXml(portalNameHome)?.observe(this, Observer {
                channelAdapter.items = it ?: emptyList()
                channelAdapter.notifyDataSetChanged()
            })
            isSortASC = false
        }
    }

    fun initFiltrByPortalName(viewHomeList: List<Portal>) {
        for (i in viewHomeList) {
            if (i.portalName == portalNameHome) {
                viewModel.fetchData(i.adress, i.name ?: "", i.portalName ?: "")
            }
        }
        channelAdapter.initFilterItems(portalNameHome , allItems)
    }

}
