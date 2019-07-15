package pl.mobileappacademy.rssreader.fragments.HomeFragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import pl.mobileappacademy.rssreader.R

class PortalRSS : Fragment() {

    companion object {
        fun newInstance() = PortalRSS()
    }

    private lateinit var viewModel: PortalRsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.portal_rs_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PortalRsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
