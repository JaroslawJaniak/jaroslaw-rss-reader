package pl.mobileappacademy.rssreader.presentation.activities

import androidx.navigation.NavController
import pl.mobileappacademy.rssreader.presentation.fragments.navBars.BottomBar

interface MainActivityInteractions {
    fun getNavigationController(): NavController
    fun getBottomBar(): BottomBar
}