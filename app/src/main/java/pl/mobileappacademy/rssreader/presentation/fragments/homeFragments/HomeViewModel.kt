package pl.mobileappacademy.rssreader.presentation.fragments.homeFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.data.database.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.data.database.PortalDao
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseViewModel
import pl.mobileappacademy.rssreader.data.models.HomeItem
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portalDao: PortalDao? = null

    fun getHomeListView() = arrayListOf<HomeItem>(
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
        portalDao = appDb?.portalDao()

                AsyncTask.execute {

                    val entityCount = appDb?.portalDao()?.getCount()?.or(0)

                    if (entityCount == 0) {
                        for (i in getHomeListView()) {
                            with(portalDao) {
                                this?.insert(i)
                            }
                        }
                    }
                }

    }

}
