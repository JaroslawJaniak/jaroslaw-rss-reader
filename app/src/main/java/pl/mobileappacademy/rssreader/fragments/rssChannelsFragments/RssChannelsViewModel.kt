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

    fun getHomeListViewTVN() = listOf(
        HomeListItem(
            1,
            "Najnowsze",
            "",
            "https://www.tvn24.pl/najnowsze.xml",
            ""
        )/*,
        HomeListItem(
            2,
            "Najważniejsze",
            "",
            "https://www.tvn24.pl/najwazniejsze.xml",
            ""
        ),
        HomeListItem(
            3,
            "Galerie",
            "",
            "https://www.tvn24.pl/zdjecia.xml",
            ""
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
            "Polska",
            "",
            "https://www.tvn24.pl/wiadomosci-z-kraju,3.xml",
            ""
        ),
        HomeListItem(
            6,
            "Świat",
            "",
            "https://www.tvn24.pl/wiadomosci-ze-swiata,2.xml",
            ""
        )*/
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
            for (i in getHomeListViewTVN()) {
                with(portlalDao) {
                    this?.insertPortal(i)
                }
            }
        }

    }
}
