package pl.mobileappacademy.rssreader.fragments.HomeFragments

import android.content.Context
import android.os.AsyncTask
import android.view.LayoutInflater
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import kotlinx.android.synthetic.main.login_dialog.view.*
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.models.HomeItem
import javax.inject.Inject

class HomeViewModel : BaseViewModel() {

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null
    lateinit var insertItem: HomeItem

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://www.tvn24.pl/rss.html", "none"
        ),
        HomeItem(
            2,
            "INTERIA",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://rss.interia.pl/news-rss-interia-pl,nId,2611437", "none"
        ),
        HomeItem(
            3,
            "POLSAT NEWS",
            "https://www.polsatnews.pl/templates/pnews2018/build/gfx/logo.svg",
            "https://www.polsatnews.pl/kanaly-rss/", "none"
        ),
        HomeItem(
            4,
            "tvn24",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://www.tvn24.pl/rss.html", "none"
        ),
        HomeItem(
            5,
            "INTERIA",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://rss.interia.pl/news-rss-interia-pl,nId,2611437", "none"
        )
    )

    var listOfItems: List<HomeItem> = getHomeListView()

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
