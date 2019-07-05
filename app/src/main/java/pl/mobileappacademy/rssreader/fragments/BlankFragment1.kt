package pl.mobileappacademy.rssreader.fragments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.blank_fragment_1_fragment.*
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.Injector

import pl.mobileappacademy.rssreader.R

class BlankFragment1 : Fragment() {


    companion object {
        fun newInstance() = BlankFragment1()
    }

    private lateinit var viewModel: BlankFragment1ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.blank_fragment_1_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(BlankFragment1ViewModel::class.java)
        // TODO: Use the ViewModel

        button3.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.mainPage, null))

        button1.setOnClickListener {
            findNavController().navigate(R.id.blankFragment2)
        }


        viewModel.showToast()
    }

}
