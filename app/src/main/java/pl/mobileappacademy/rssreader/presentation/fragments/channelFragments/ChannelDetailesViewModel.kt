package pl.mobileappacademy.rssreader.presentation.fragments.channelFragments

import android.content.Context
import androidx.lifecycle.MutableLiveData
import pl.mobileappacademy.rssreader.Injector
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.BaseViewModel
import pl.mobileappacademy.rssreader.data.models.rssModels.Channel
import pl.mobileappacademy.rssreader.data.models.rssModels.Rss
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ChannelDetailesViewModel : BaseViewModel() {
    @Inject
    lateinit var api: RetrofitService

    @Inject
    lateinit var context: Context

    val channelDetailes = MutableLiveData<List<Channel>>()
    val errors = MutableLiveData<Throwable>()
    val refreshing = MutableLiveData<Boolean>()

    init {
        Injector.component.inject(this)
    }

    fun fetchData(url: String?) {
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
                        channelDetailes.value = it.channels
                        refreshing.value = false
                        errors.value = null
                    }
                }
            }
        })
    }
}
