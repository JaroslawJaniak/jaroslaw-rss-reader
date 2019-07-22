package pl.mobileappacademy.rssreader.fragments.RSSFragments

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
import kotlinx.android.synthetic.main.add_dialog_spinner.view.*
import kotlinx.android.synthetic.main.channel_fragment.*
import kotlinx.android.synthetic.main.channel_fragment.channel_recycle_view
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsViewModel
import pl.mobileappacademy.rssreader.fragments.dialogs.DialogFilterFragment
import pl.mobileappacademy.rssreader.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.models.HomeListItem
import pl.mobileappacademy.rssreader.models.rssModels.Channel

class ChannelFragment : BaseFragment(), BottomBar.AppBottomBarListener {

    private lateinit var itemToInsert: HomeListItem
    val dialog = DialogFilterFragment()
    private lateinit var viewModel: ChannelViewModel
    private val channelAdapter by lazy { ChannelAdapter() }

    private lateinit var viewHomeList: List<HomeListItem>

    private lateinit var viewChannel: List<Channel>

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

        viewHomeList = RssChannelsViewModel().getHomeListViewTVN()
        viewChannel = ChannelDetailsAdapter().items

        for (i in viewHomeList) {
            val url = i.adress
            viewModel.fetchData(url, i.name ?: "")
        }

        viewModel.itemsChannelList.observe(this, Observer {
            channelAdapter.updateData(it ?: emptyList())
            channelAdapter.notifyDataSetChanged()
        })

        bottomBar?.setBottomBarListener(this)

        channel_filtr_button.setOnClickListener {
            //navigate?.navigate(R.id.channelDetailesFragment)
            navigate?.navigate(R.id.rssChannelsFragment)
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

        val spinner = mDialogView.spinner.selectedItem as String


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

    override fun onHomeClick() {
        navigate?.navigate(R.id.homeFragment)
    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {
        dialog.show(fragmentManager, "DialogFilterFragment")
    }

}
