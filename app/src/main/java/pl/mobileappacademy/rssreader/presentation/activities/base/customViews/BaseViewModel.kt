package pl.mobileappacademy.rssreader.presentation.activities.base.customViews

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

open class BaseViewModel : ViewModel() {
    var navigate: NavController? = null

}