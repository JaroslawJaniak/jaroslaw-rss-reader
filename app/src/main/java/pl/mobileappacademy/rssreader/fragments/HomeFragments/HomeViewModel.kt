package pl.mobileappacademy.rssreader.fragments.HomeFragments

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.R
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin.Companion.portalDao
import pl.mobileappacademy.rssreader.base.HomeRepository
import pl.mobileappacademy.rssreader.models.HomeItem
import javax.inject.Inject

class HomeViewModel : ViewModel() {

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
        )
    )

    private lateinit var repository: HomeRepository
    lateinit var allPortals: LiveData<List<HomeItem>>

    @Inject
    lateinit var context: Context
    lateinit var coroutineScope: CoroutineScope

    init {
        Injector.component.inject(this)

        val portalsDao = AppDataBaseKotlin.getDatabase(context).homeDao()
        repository = HomeRepository(portalsDao)
        allPortals = repository.allPortals
    }

    suspend fun insert(portal: HomeItem) {
        repository.insert(portal)
    }

    fun showToast() = Toast.makeText(context, context.resources.getString(R.string.app_name), Toast.LENGTH_SHORT).show()
}
