package pl.mobileappacademy.rssreader.presentation.fragments.channelFragments

import android.content.Context
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import pl.mobileappacademy.rssreader.data.database.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.data.database.ChannelsRssDao
import pl.mobileappacademy.rssreader.data.database.ItemChannelXmlDao
import pl.mobileappacademy.rssreader.data.models.HomeListItem
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseViewModel
import pl.mobileappacademy.rssreader.data.models.rssModels.Item
import pl.mobileappacademy.rssreader.data.models.rssModels.Rss
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
    var itemChannelXmlDao: ItemChannelXmlDao? = null

    var myDataFromDB = MutableLiveData<List<HomeListItem>>()


    val itemsChannelList = MutableLiveData<List<Item>>()
    val errors = MutableLiveData<Throwable>()
    val refreshing = MutableLiveData<Boolean>()

    init {
        Injector.component.inject(this)
        loadDb()
    }


    fun loadDb(){
        appDb = AppDataBaseKotlin.getAppDataBaseKotlin(context)
        myDataFromDB.postValue(appDb?.channelsRssDao()?.getAllChannelsRss())
    }




    fun fetchData(url: String?, category: String, portalName: String) {

        appDb = AppDataBaseKotlin.getAppDataBaseKotlin(context)
        itemChannelXmlDao = appDb?.itemChannelXmlDao()

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

                                AsyncTask.execute {
                                        with(itemChannelXmlDao) {
                                            this?.insertItemChannelXml(it)
                                        }
                                }
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



