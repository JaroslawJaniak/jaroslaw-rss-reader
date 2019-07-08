package pl.mobileappacademy.rssreader.base

import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

open class BaseViewModel : ViewModel() {
    var navigate: NavController? = null

}