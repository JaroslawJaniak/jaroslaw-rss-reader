package pl.mobileappacademy.rssreader.fragments.HomeFragments

import androidx.lifecycle.ViewModel
import pl.mobileappacademy.rssreader.fragments.New_Fragments.HomeItem

class HomeViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    fun getHomeListView() = listOf(
        HomeItem(
            1,
            "tvn24",
            "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
            "https://www.tvn24.pl/rss.html"),
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

}
