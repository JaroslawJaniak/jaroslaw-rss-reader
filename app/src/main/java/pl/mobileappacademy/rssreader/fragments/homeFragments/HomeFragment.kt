package pl.mobileappacademy.rssreader.fragments.homeFragments



import android.os.AsyncTask
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.home_fragment.*
import kotlinx.android.synthetic.main.add_service_dialog.view.*
import kotlinx.android.synthetic.main.portal_dialog.view.*
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.base.OnItemClickListener
import pl.mobileappacademy.rssreader.base.addOnItemClickListener
import pl.mobileappacademy.rssreader.fragments.adapters.HomeAdapter
import pl.mobileappacademy.rssreader.fragments.navBars.BottomBar
import pl.mobileappacademy.rssreader.models.HomeItem


class HomeFragment : BaseFragment(), BottomBar.AppBottomBarListener{

    override fun onHomeClick() {

    }

    override fun onAddClick() {
        showAddDialog()
    }

    override fun onSortClick() {

    }

    private lateinit var viewModel: HomeViewModel
    private val homeAdapter by lazy { HomeAdapter() }
    lateinit var itemToInsert: HomeItem

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        //Injector.component.inject(this)

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
        mainLoginBtn.setOnClickListener {
            //showAddDialog()
        }
    }

    private fun showServiceDialog() {
        channel_recycle_view.addOnItemClickListener(object : OnItemClickListener {
            override fun onItemClicked(position: Int, view: View) {

                //Toast.makeText(context, "clicked on " + homeAdapter.items[position], Toast.LENGTH_LONG).show()

                val mDialogView = LayoutInflater.from(context).inflate(R.layout.portal_dialog, null)

                mDialogView.dialog_name.text = homeAdapter.items[position].name.toString()
                mDialogView.dialog_adressURL.text = homeAdapter.items[position].adress.toString()
                mDialogView.dialog_category.text = homeAdapter.items[position].category.toString()

                val mBuilder = context?.let { it1 ->
                    AlertDialog.Builder(it1)
                        .setView(mDialogView)
                        .setTitle(" ")
                }

                val mAlertDialog = mBuilder?.show()

                mDialogView.dialog_portal_button.setOnClickListener {
                    findNavController().navigate(R.id.channelFragment)
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

        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_service_dialog, null)
        val mBuilder = context?.let { it1 ->
            AlertDialog.Builder(it1)
                .setView(mDialogView)
                .setTitle(" ")

        }
        val mAlertDialog = mBuilder?.show()

        mDialogView.login_dialog_OkBtn.setOnClickListener {

            val nazwa = mDialogView.login_dialog_name.text.toString()

            itemToInsert = HomeItem()
            itemToInsert.name = nazwa

            AsyncTask.execute {

                viewModel.appDb?.portalDao()?.insert(itemToInsert)
            }

            mAlertDialog?.dismiss()
        }

        mDialogView.login_dialog_CancelBtn.setOnClickListener {
            mAlertDialog?.dismiss()
        }
    }

}

