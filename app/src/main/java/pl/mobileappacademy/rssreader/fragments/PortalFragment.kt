package pl.mobileappacademy.rssreader.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
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


import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.blank_fragment2_fragment.*


import kotlinx.android.synthetic.main.portal_fragment.*
import pl.mobileappacademy.rssreader.models.Portal
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PortalFragment() : Fragment() {
    companion object {
        fun newInstance(): PortalFragment {
            return PortalFragment()
        }
    }

    private val portalList = ArrayList<Portal>()
    private var adapter: PortalFragment? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setAdapter()
        getDataFromDatabase()
        downloadDataCheck()

        button5.setOnClickListener {
            findNavController().navigate(R.id.blankFragment_1)
        }

        //navigationInteractions.topBar.setTopBarTitle("Fragment A")

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(
            R.layout.portal_fragment, container, false
        )

    }

    private fun getDataFromDatabase() {
        //postList.addAll(SQLite.select().from(Portal::class.java).queryList());
        //adapter?.notifyDataSetChanged()
    }

    private fun downloadDataCheck() {
        if (portalList.size == 0) {
            Toast.makeText(context, "Pobieranie danych z API bo baza jest pusta", Toast.LENGTH_SHORT).show()
            fetchData()
        } else {
            Toast.makeText(context, "Pobrano dane z bazy danych", Toast.LENGTH_SHORT).show()
        }
    }

    private fun setAdapter() {
        adapter = PortalFragment()

        portal_recycle_view?.let {
            it.layoutManager = LinearLayoutManager(context)
            //it.adapter = adapter ???
        }
    }

    private fun setListeners() {
        //refresh_button.setOnClickListener { fetchData() }
        //go_to_fragmentA_button.setOnClickListener { navigationInteractions.changeFragment(FragmentA.newInstance(),false) }
    }


    private fun fetchData() {
        Toast.makeText(context, "Pobieranie danych z api", Toast.LENGTH_SHORT).show()

        /*Rest.getRest().postsKotlin.enqueue(object : Callback<List<Portal>> {
            override fun onResponse(call: Call<List<Portal>>, response: Response<List<Portal>>) {
                if (response.isSuccessful && response.body() != null) {

                    for (portal in response.body()!!) {
                        val p = Portal()
                        p.userId = portal.userId
                        p.id = portal.id
                        p.title = portal.title
                        p.body = portal.body
                        p.save()
                    }

                    response.body()?.let { portalList.addAll(it) }
                    adapter?.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<List<Portal>>, t: Throwable) {
                Toast.makeText(context, t.message, Toast.LENGTH_LONG).show()
            }
        })*/
    }
}
