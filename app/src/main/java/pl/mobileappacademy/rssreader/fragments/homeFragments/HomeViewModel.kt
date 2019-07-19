package pl.mobileappacademy.rssreader.fragments.homeFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.models.HomeItem
import pl.mobileappacademy.rssreader.models.rssModels.Item
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null
    val itemsChannelList = MutableLiveData<List<HomeItem>>()

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "",
            "https://www.tvn24.pl/rss.html", "none"
        )
    )

    @Inject
    lateinit var context: Context

    init {
        Injector.component.inject(this)
        insertToDatabase()
    }

    private fun insertToDatabase() {
        appDb = AppDataBaseKotlin.getAppDataBaseKotlin(context)
        portlalDao = appDb?.portalDao()

        AsyncTask.execute {
            for (i in getHomeListView()) {
                with(portlalDao) {
                    this?.insert(i)
                }
            }
        }

    }


}
