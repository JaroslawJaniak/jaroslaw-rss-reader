package pl.mobileappacademy.rssreader.fragments.homeFragments

import android.content.Context
import android.os.AsyncTask
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.models.HomeItem
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "",
            "https://www.tvn24.pl/rss.html", false
        ),
        HomeItem(
            2,
            "POLSAT NEWS",
            "",
            "https://www.polsatnews.pl/kanaly-rss/", false
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
