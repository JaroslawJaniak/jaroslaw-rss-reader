package pl.mobileappacademy.rssreader.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.blank_fragment2_fragment.*
import kotlinx.android.synthetic.main.blank_fragment_1_fragment.*

import pl.mobileappacademy.rssreader.R

class BlankFragment2 : Fragment() {

    companion object {
        fun newInstance() = BlankFragment2()
    }

    private lateinit var viewModel: BlankFragment2ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.blank_fragment2_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankFragment2ViewModel::class.java)
        // TODO: Use the ViewModel

        button2.setOnClickListener {
            findNavController().navigate(R.id.portalFragment)
        }


    }

}
