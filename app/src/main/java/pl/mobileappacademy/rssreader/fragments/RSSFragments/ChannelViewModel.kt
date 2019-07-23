package pl.mobileappacademy.rssreader.fragments.RSSFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.MutableLiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.models.rssModels.Item
import pl.mobileappacademy.rssreader.models.rssModels.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ChannelViewModel : BaseViewModel() {

    @Inject
    lateinit var api: RetrofitService

    @Inject
    lateinit var context: Context

    var appDb: AppDataBaseKotlin? = null

    val itemsChannelList = MutableLiveData<List<Item>>()
    val errors = MutableLiveData<Throwable>()
    val refreshing = MutableLiveData<Boolean>()

    init {
        Injector.component.inject(this)
    }

    fun fetchData(url: String?, category: String, portalName: String) {
        refreshing.value = true

        api.getRssCh(url).enqueue(object: Callback<Rss> {
            override fun onFailure(call: Call<Rss>, t: Throwable) {
                errors.value = t
                refreshing.value = false
                println("")
            }

            override fun onResponse(call: Call<Rss>, response: Response<Rss>) {
                if (response.isSuccessful) {

                    response.body()?.let {
                        refreshing.value = false
                        val listWithCategory = arrayListOf<Item>()

                        it.channels?.forEach {

                            it.items?.forEach {
                                it.portalName = portalName
                                it.category = category
                                listWithCategory.add(it)
                            }


                        }

                        itemsChannelList.value = listWithCategory
                        errors.value = null
                    }
                }
            }
        })
    }

}



