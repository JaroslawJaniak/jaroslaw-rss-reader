package pl.mobileappacademy.rssreader.presentation.activities.base.customViews

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import pl.mobileappacademy.rssreader.presentation.activities.MainActivityInteractions
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar


open class BaseFragment : Fragment() {
    var navigation: NavController? = null
        private set

    var bottomBar: BottomBar? = null
        private set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navigation = (context as? MainActivityInteractions)?.getNavigationController()
        bottomBar = (context as? MainActivityInteractions)?.getBottomBar()
    }

    override fun onDetach() {
        super.onDetach()
        navigation = null
        bottomBar = null
    }

}