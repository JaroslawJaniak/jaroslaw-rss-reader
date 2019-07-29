package pl.mobileappacademy.rssreader.Retrofit


import pl.mobileappacademy.rssreader.data.models.rssModels.Rss
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface RetrofitService {

    @GET("/najnowsze.xml")
    fun getRss(): Call<Rss>

    @GET
    fun getRssCh(@Url url: String?): Call<Rss>

}

