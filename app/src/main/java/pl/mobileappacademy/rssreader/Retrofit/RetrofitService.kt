package pl.mobileappacademy.rssreader.Retrofit


import pl.mobileappacademy.rssreader.models.rssModels.Rss
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Url
import java.net.URL

interface RetrofitService {

    @GET("/najnowsze.xml")
    fun getRss(): Call<Rss>

    @GET
    fun getRssCh(@Url url: String?): Call<Rss>

}

