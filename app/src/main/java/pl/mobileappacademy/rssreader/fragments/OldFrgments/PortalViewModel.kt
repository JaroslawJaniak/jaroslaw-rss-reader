package pl.mobileappacademy.rssreader.fragments.OldFrgments

import androidx.lifecycle.ViewModel;
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.models.Portal

class PortalViewModel : BaseViewModel() {
    // TODO: Implement the ViewModel
    //todo: dodac metode zwracajaca liste danych

    private  var portalList = listOf<Portal>(
       Portal(1, "portal1", "portal1URL"),
        Portal(2,"portal2", "portal2URL"),
        Portal(3,"portal3", "portal3URL")
    )

    fun getListOfPortals() = portalList

}
