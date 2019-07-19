package pl.mobileappacademy.rssreader

import androidx.navigation.NavController
import pl.mobileappacademy.rssreader.fragments.navBars.BottomBar

interface MainActivityInteractions {
    fun getNavigationController(): NavController
    fun getBottomBar(): BottomBar
}