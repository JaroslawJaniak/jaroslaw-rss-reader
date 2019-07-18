package pl.mobileappacademy.rssreader.fragments.RSSFragments

import android.content.Context
import android.graphics.Movie
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel;
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin
import pl.mobileappacademy.rssreader.base.BaseViewModel
import pl.mobileappacademy.rssreader.di.modules.RestModule
import pl.mobileappacademy.rssreader.models.rssModels.Item
import pl.mobileappacademy.rssreader.models.rssModels.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.security.AccessController.getContext
import javax.inject.Inject

class ChannelViewModel : BaseViewModel() {

    @Inject
    lateinit var api: RetrofitService
/*
    @Inject
    lateinit var appDb: AppDataBaseKotlin
*/
    @Inject
    lateinit var context: Context
    val itemsChannelList = MutableLiveData<List<Item>>()
    val errors = MutableLiveData<Throwable>()
    val refreshing = MutableLiveData<Boolean>()

    init {
        Injector.component.inject(this)
        //fetchData()
    }

    fun fetchData() {
        refreshing.value = true

        api.getRss().enqueue(object: Callback<Rss> {
            override fun onFailure(call: Call<Rss>, t: Throwable) {
                errors.value = t
                refreshing.value = false
                println("")
            }

            override fun onResponse(call: Call<Rss>, response: Response<Rss>) {
                if (response.isSuccessful) {

                    Toast.makeText(context, "response.isSuccessful",Toast.LENGTH_LONG).show()

                    response.body()?.let {
                        refreshing.value = false
                        itemsChannelList.value = it.channel?.items
                        errors.value = null
                    }
                }
            }
        })
    }

    fun fetchData2(url: String?, category: String) {
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
                        it.channel?.items?.forEach {
                            it.category = category
                            listWithCategory.add(it)
                        }
                        itemsChannelList.value = listWithCategory
                        errors.value = null
                    }
                }
            }
        })
    }
    }



