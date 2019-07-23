package pl.mobileappacademy.rssreader.fragments.RSSFragments

import android.os.AsyncTask
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Spinner
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_dialog_spinner.view.*
import kotlinx.android.synthetic.main.add_dialog_spinner.view.add_dialog_CancelBtn
import kotlinx.android.synthetic.main.add_dialog_spinner.view.add_dialog_OkBtn
import kotlinx.android.synthetic.main.channel_fragment.*
import kotlinx.android.synthetic.main.channel_fragment.channel_recycle_view
import kotlinx.android.synthetic.main.dialog_filter_spinner.*
import kotlinx.android.synthetic.main.dialog_filter_spinner.view.spinner_filter
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsViewModel
import pl.mobileappacademy.rssreader.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.models.HomeListItem

class ChannelFragment : BaseFragment(), BottomBar.AppBottomBarListener {

    private lateinit var itemToInsert: HomeListItem
    private lateinit var viewModel: ChannelViewModel
    private lateinit var viewHomeList: List<HomeListItem>
    private var portalNameHome: String? = ""
    private var filterCategory: String? = ""

    var categoryFilter = arrayOf("Najnowsze", "Najważniejsze", "Galerie", "Sport", "Polska", "Świat", "Inne...")
    var spinner: Spinner? = null

    private val channelAdapter by lazy { ChannelAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            portalNameHome = it.getString("SERIVISE_FILTER")
        }

        spinner = this.spinner_filter
        spinner!!.selectedItem
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

        viewHomeList = RssChannelsViewModel().getHomeListView()

        for (i in viewHomeList) {
            val url = i.adress
            if (i.portalName == portalNameHome) {
                viewModel.fetchData(url, i.name ?: "", i.portalName ?: "")
            }
        }

        viewModel.itemsChannelList.observe(this, Observer {
            channelAdapter.updateData(it ?: emptyList())
            channelAdapter.notifyDataSetChanged()
        })

        bottomBar?.setBottomBarListener(this)

        channel_filtr_button.setOnClickListener {
            navigate?.navigate(R.id.channelDetailesFragment)
        }
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
            val category = mDialogView.spinner.selectedItem.toString()
            val name = mDialogView.spinner.selectedItem.toString()

            itemToInsert = HomeListItem()
            itemToInsert.name = name
            itemToInsert.adress = url
            itemToInsert.category = category

            AsyncTask.execute {
                viewModel.appDb?.portalDao()?.insertPortal(itemToInsert)
            }

            mAlertDialog?.dismiss()
        }

        mDialogView.add_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }

    private fun showFilterDialog() {

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.dialog_filter_spinner, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle("Fitruj według kategorii")

        }
        val mAlertDialog = mBuilder?.show()

        mDialogView.add_dialog_OkBtn.setOnClickListener {
            filterCategory = mDialogView.spinner_filter.selectedItem.toString()
            mAlertDialog?.dismiss()
        }

        mDialogView.add_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }

    override fun onHomeClick() {
        navigate?.navigate(R.id.homeFragment)
    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {
        showFilterDialog()
    }

}
