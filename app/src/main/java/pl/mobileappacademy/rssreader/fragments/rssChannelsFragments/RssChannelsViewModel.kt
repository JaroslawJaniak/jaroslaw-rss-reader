package pl.mobileappacademy.rssreader.fragments.rssChannelsFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.ViewModel
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.models.HomeListItem
import javax.inject.Inject

class RssChannelsViewModel : ViewModel() {

    fun getHomeListView() = listOf(
        HomeListItem(
            1,
            "Najnowsze",
            "",
            "https://www.tvn24.pl/najnowsze.xml",
            "",
            "tvn24"
        ),
        HomeListItem(
            2,
            "Najważniejsze",
            "",
            "https://www.tvn24.pl/najwazniejsze.xml",
            "",
            "tvn24"
        ),
        HomeListItem(
            3,
            "Polska",
            "",
            "https://www.tvn24.pl/wiadomosci-z-kraju,3.xml",
            "",
            "tvn24"
        ),
        HomeListItem(
            4,
            "Sport",
            "",
            "https://eurosport.tvn24.pl/sport,81,m.xml",
            ""
        ),
        HomeListItem(
            5,
            "Świat",
            "",
            "https://www.tvn24.pl/wiadomosci-ze-swiata,2.xml",
            ""
        ),
        HomeListItem(
            6,
            "Polska",
            "",
            "https://www.polsatnews.pl/rss/polska.xml",
            "",
            "POLSAT NEWS"
        ),
        HomeListItem(
            7,
            "Świat",
            "",
            "https://www.polsatnews.pl/rss/swiat.xml",
            "",
            "POLSAT NEWS"
        )
    )

    var appDb: AppDataBaseKotlin? = null
    var portlalDao: PortalDao? = null

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
                    this?.insertPortal(i)
                }
            }
        }

    }
}
