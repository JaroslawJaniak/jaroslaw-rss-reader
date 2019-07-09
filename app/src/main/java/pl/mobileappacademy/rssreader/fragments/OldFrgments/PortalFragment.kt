package pl.mobileappacademy.rssreader.fragments.OldFrgments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.mobileappacademy.rssreader.R
/*
class PortalFragment : Fragment() {

    companion object {
        fun newInstance() = PortalFragment()
    }

    private lateinit var viewModel: PortalViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.portal_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PortalViewModel::class.java)
        // TODO: Use the ViewModel
    }

}*/


import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager


import kotlinx.android.synthetic.main.portal_fragment.*
import pl.mobileappacademy.rssreader.base.BaseFragment
import pl.mobileappacademy.rssreader.models.Portal

class PortalFragment() : BaseFragment() {
    companion object {
        fun newInstance(): PortalFragment {
            return PortalFragment()
        }
    }


    private val portalList = ArrayList<Portal>()
    private lateinit var viewModel: PortalViewModel

    //private var adapter: PortalAdapter? = null
    val adapter by lazy { PortalAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setAdapter()

        //getDataFromDatabase()
        //downloadDataCheck()

        button5.setOnClickListener {
            findNavController().navigate(R.id.blankFragment_1)
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(
            R.layout.portal_fragment, container, false
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PortalViewModel::class.java)


        //todo za pomoca viewmodelu odwloac sie do odpowiedniej metody z vm i pobrac dane do portalList
        //todo: przekazac portalList do adaptera


    }

    private fun setAdapter() {
        //adapter = PortalAdapter()
        adapter.items = viewModel.getListOfPortals()

        portal_recycle_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = adapter
        }
    }


    private fun setListeners() {
        //refresh_button.setOnClickListener { fetchData() }
        //go_to_fragmentA_button.setOnClickListener { navigationInteractions.changeFragment(FragmentA.newInstance(),false) }
    }


}





