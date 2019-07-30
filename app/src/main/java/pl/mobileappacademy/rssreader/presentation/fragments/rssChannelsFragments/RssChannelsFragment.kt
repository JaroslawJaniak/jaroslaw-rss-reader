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
import kotlinx.android.synthetic.main.add_dialog.view.*
import kotlinx.android.synthetic.main.rss_channels_fragment.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseFragment
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.OnItemClickListener
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.addOnItemClickListener
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.data.models.Portal


class RssChannelsFragment : BaseFragment(), BottomBar.AppBottomBarListener {

    var allItems = arrayListOf<Portal>()
    private lateinit var viewHomeList: List<Portal>
    private lateinit var itemToInsert: Portal
    private var portalNameHome: String? = ""
    var isSortASC = false

    private lateinit var viewModel: RssChannelsViewModel
    private val rssChannelsAdapter by lazy { RssChannelsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            portalNameHome = it.getString("SERVISE_FILTER")
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


        viewModel.appDb?.channelsRssDao()?.getByPortalNameChannelsRss(portalNameHome)?.observe(this, Observer {
            rssChannelsAdapter.items = it ?: emptyList()
            rssChannelsAdapter.notifyDataSetChanged()
        })

        viewModel.homeListItemlList.observe(this, Observer {
            allItems.addAll(it)
            rssChannelsAdapter.updateData(it ?: emptyList())
            rssChannelsAdapter.notifyDataSetChanged()
        })


        bottomBar?.setBottomBarListener(this)
        setListeners()
    }

    private fun setListeners() {
        rss_channels_recycle_view.addOnItemClickListener(object :
            OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {
                val item = rssChannelsAdapter.items[position]

                val bundle = Bundle()
                bundle.putString("SERVISE_FILTER", portalNameHome)
                bundle.putString("SERVISE_CHANNEL", item.name)
                findNavController().navigate(R.id.channelFragment, bundle)
            }
        })
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

            viewModel.appDb?.channelsRssDao()?.sortByNameASCChannelsRss(portalNameHome)?.observe(this, Observer {
                rssChannelsAdapter.items = it ?: emptyList()
                rssChannelsAdapter.notifyDataSetChanged()
            })

            isSortASC = true
        }
        else{
            viewModel.appDb?.channelsRssDao()?.sortByNameDSCChannelsRss(portalNameHome)?.observe(this, Observer {
                rssChannelsAdapter.items = it ?: emptyList()
                rssChannelsAdapter.notifyDataSetChanged()
            })
            isSortASC = false
        }
    }
}
