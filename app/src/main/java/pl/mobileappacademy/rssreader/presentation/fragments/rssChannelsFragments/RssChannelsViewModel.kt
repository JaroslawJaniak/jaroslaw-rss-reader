package pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.data.database.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.data.database.ChannelsRssDao
import pl.mobileappacademy.rssreader.data.models.Portal
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseViewModel
import javax.inject.Inject

class RssChannelsViewModel : BaseViewModel() {

    fun getHomeListView() = listOf(
        Portal(
            1,
            "Najnowsze",
            "",
            "https://www.tvn24.pl/najnowsze.xml",
            "tvn24"
        ),
        Portal(
            2,
            "Najważniejsze",
            "",
            "https://www.tvn24.pl/najwazniejsze.xml",
            "tvn24"
        ),
        Portal(
            3,
            "Polska",
            "",
            "https://www.tvn24.pl/wiadomosci-z-kraju,3.xml",
            "tvn24"
        ),
        Portal(
            4,
            "Sport",
            "",
            "https://eurosport.tvn24.pl/sport,81,m.xml",
            "tvn24"
        ),
        Portal(
            5,
            "Świat",
            "",
            "https://www.tvn24.pl/wiadomosci-ze-swiata,2.xml",
            "tvn24"
        ),
        Portal(
            6,
            "Polska",
            "",
            "https://www.polsatnews.pl/rss/polska.xml",
            "POLSAT NEWS"
        ),
        Portal(
            7,
            "Świat",
            "",
            "https://www.polsatnews.pl/rss/swiat.xml",
            "POLSAT NEWS"
        )
    )

    var appDb: AppDataBaseKotlin? = null
    var channelsRssDao: ChannelsRssDao? = null
    val homeListItemlList = MutableLiveData<ArrayList<Portal>>()

    @Inject
    lateinit var context: Context

    init {
        Injector.component.inject(this)
        insertToDatabaseChannelsRss()
    }

    fun insertToDatabaseChannelsRss() {
        appDb = AppDataBaseKotlin.getAppDataBaseKotlin(context)
        channelsRssDao = appDb?.channelsRssDao()

        AsyncTask.execute {

            val entityCount = appDb?.channelsRssDao()?.getCount()?.or(0)

            val listWithCategory = arrayListOf<Portal>()

            if (entityCount == 0){
                for (i in getHomeListView()) {
                    with(channelsRssDao) {
                        this?.insertChannelsRss(i)
                        listWithCategory.add(i)
                    }
                }
                //homeListItemlList.value = listWithCategory

            }
        }


    }

}
