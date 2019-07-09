package pl.mobileappacademy.rssreader.fragments.New_Fragments

import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    private  var homeList = listOf(
        HomeItem(1, "portal1", "portal1URL"),
        HomeItem(2,"portal2", "portal2URL"),
        HomeItem(3,"portal3", "portal3URL")
    )

    fun getHomeListView() = homeList
}
