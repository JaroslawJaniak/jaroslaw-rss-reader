package pl.mobileappacademy.rssreader.presentation.fragments.homeFragments

import android.content.Context
import android.os.AsyncTask
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.data.database.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.data.database.PortalDao
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseViewModel
import pl.mobileappacademy.rssreader.data.models.HomeItem
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "",
            "https://www.tvn24.pl/rss.html"
        ),
        HomeItem(
            2,
            "POLSAT NEWS",
            "",
            "https://www.polsatnews.pl/kanaly-rss/"
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
