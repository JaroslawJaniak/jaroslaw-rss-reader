package pl.mobileappacademy.rssreader.Retrofit

import pl.mobileappacademy.rssreader.models.HomeItem
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/najnowsze.xml")
    abstract fun getTvn24(): Call<List<HomeItem>>

    @GET("/najwazniejsze.xml")
    abstract fun getInteria(): Call<List<HomeItem>>

}

