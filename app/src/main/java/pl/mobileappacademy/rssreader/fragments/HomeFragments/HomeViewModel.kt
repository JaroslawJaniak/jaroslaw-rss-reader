package pl.mobileappacademy.rssreader.fragments.HomeFragments

import android.content.Context
import android.database.sqlite.SQLiteQuery
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.models.HomeItem
import javax.inject.Inject

class HomeViewModel : ViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://www.tvn24.pl/rss.html"
        ),
        HomeItem(
            2,
            "INTERIA",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://rss.interia.pl/news-rss-interia-pl,nId,2611437"
        ),
        HomeItem(
            3,
            "POLSAT NEWS",
            "https://www.polsatnews.pl/templates/pnews2018/build/gfx/logo.svg",
            "https://www.polsatnews.pl/kanaly-rss/"
        ),
        HomeItem(
            4,
            "tvn24",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://www.tvn24.pl/rss.html"
        ),
        HomeItem(
            5,
            "INTERIA",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://rss.interia.pl/news-rss-interia-pl,nId,2611437"
        )
    )

    var itemTest: HomeItem = getHomeListView()[1]


    @Inject
    lateinit var context: Context

    init {
        Injector.component.inject(this)
        insertToDatabase()
    }

    private fun insertToDatabase() {
        appDb = AppDataBaseKotlin.getAppDataBaseKotlin(context)
        portlalDao = appDb?.portalDao()


        //todo: przeniesc na watek boczny

        AsyncTask.execute {

            for (i in getHomeListView()) {
                with(portlalDao) {
                    this?.insert(i)
                }
            }

        }

    }
}
