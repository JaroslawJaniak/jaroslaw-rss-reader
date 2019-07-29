package pl.mobileappacademy.rssreader.presentation.fragments.homeFragments



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
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.add_dialog.view.*
import kotlinx.android.synthetic.main.portal_dialog.view.*
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseFragment
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.OnItemClickListener
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.addOnItemClickListener
import pl.mobileappacademy.rssreader.presentation.fragments.adapters.HomeAdapter
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.data.models.HomeItem


class HomeFragment : BaseFragment(), BottomBar.AppBottomBarListener{

    private lateinit var viewModel: HomeViewModel
    private val homeAdapter by lazy { HomeAdapter() }
    lateinit var itemToInsert: HomeItem
    var isSortASC = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        viewModel.appDb?.portalDao()?.getAll()?.observe(this, Observer {
            homeAdapter.items = it ?: emptyList()
            homeAdapter.notifyDataSetChanged()
        })

        channel_recycle_view.apply {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = homeAdapter
        }

        bottomBar?.setBottomBarListener(this)

        showServiceDialog()

    }

    private fun showServiceDialog() {
        channel_recycle_view.addOnItemClickListener(object :
            OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                val item = homeAdapter.items[position]

                val mDialogView = LayoutInflater.from(context).inflate(R.layout.portal_dialog, null)

                mDialogView.dialog_name.text = item.name.toString()
                mDialogView.dialog_adressURL.text = item.adress.toString()

                val mBuilder = context?.let { it1 ->
                    AlertDialog.Builder(it1)
                        .setView(mDialogView)
                        .setTitle(" ")
                }

                val mAlertDialog = mBuilder?.show()

                mDialogView.dialog_portal_button.setOnClickListener {
                    val bundle = Bundle()
                    bundle.putString("SERIVISE_FILTER", item.name)
                    findNavController().navigate(R.id.channelFragment, bundle)
                    homeAdapter.items[position].isAdded = true

                        mAlertDialog?.dismiss()
                }

                mDialogView.dialog_portal_button_usun.setOnClickListener {
                    AsyncTask.execute {
                        viewModel.appDb?.portalDao()?.delete(homeAdapter.items[position])
                    }
                    mAlertDialog?.dismiss()
                }
            }
        })
    }

    private fun showAddDialog() {

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_dialog, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle(" ")

        }

        val mAlertDialog = mBuilder?.show()

        mDialogView.login_dialog_OkBtn.setOnClickListener {

            val nazwa = mDialogView.login_dialog_name.text.toString()
            val url = mDialogView.login_dialogAdressURL.text.toString()

            itemToInsert = HomeItem()
            itemToInsert.name = nazwa
            itemToInsert.adress = url

            AsyncTask.execute {
                viewModel.appDb?.portalDao()?.insert(itemToInsert)
            }

            mAlertDialog?.dismiss()
        }

        mDialogView.login_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }

    override fun onHomeClick() {

    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {
        if (!isSortASC) {

            viewModel.appDb?.portalDao()?.sortByASCName()?.observe(this, Observer {
                homeAdapter.items = it ?: emptyList()
                homeAdapter.notifyDataSetChanged()
            })

            isSortASC = true
        } else {
            viewModel.appDb?.portalDao()?.sortByDSCName()?.observe(this, Observer {
                homeAdapter.items = it ?: emptyList()
                homeAdapter.notifyDataSetChanged()
            })
            isSortASC = false
        }
    }
}

