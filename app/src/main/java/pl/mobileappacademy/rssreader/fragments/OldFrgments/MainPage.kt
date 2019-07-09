package pl.mobileappacademy.rssreader.fragments.OldFrgments

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.main_page_fragment.*

import pl.mobileappacademy.rssreader.R

class MainPage : Fragment() {

    companion object {
        fun newInstance() = MainPage()
    }

    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.main_page_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainPageViewModel::class.java)
        // TODO: Use the ViewModel

        button5.setOnClickListener {
            findNavController().navigate(R.id.blankFragment_1)
        }
    }

}
