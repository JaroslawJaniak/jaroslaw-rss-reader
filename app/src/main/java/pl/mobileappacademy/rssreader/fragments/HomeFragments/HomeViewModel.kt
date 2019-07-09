package pl.mobileappacademy.rssreader.fragments.HomeFragments

import androidx.lifecycle.ViewModel
import pl.mobileappacademy.rssreader.fragments.New_Fragments.HomeItem

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun getHomeListView() = listOf(
        HomeItem(1, "portal1", "portal1URL"),
        HomeItem(2,"portal2", "portal2URL"),
        HomeItem(3,"portal3", "portal3URL")
    )

}
