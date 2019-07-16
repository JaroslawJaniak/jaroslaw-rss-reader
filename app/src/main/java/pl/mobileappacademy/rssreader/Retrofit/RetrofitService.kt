package pl.mobileappacademy.rssreader.Retrofit


import pl.mobileappacademy.rssreader.models.rssModels.Rss
import retrofit2.Call
import retrofit2.http.GET




interface RetrofitService {

    @GET("/najnowsze.xml")
    fun getRss(): Call<Rss>

}

