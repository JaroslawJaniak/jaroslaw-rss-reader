package pl.mobileappacademy.rssreader.Retrofit

import pl.mobileappacademy.rssreader.models.Portal
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitService {

    @GET("/najnowsze.xml")
    abstract fun getTvn24(): Call<List<Portal>>

    @GET("/feed")
    abstract fun getInteria(): Call<List<Portal>>

    //???



    /*
    @GET("posts")
    abstract fun getPostsKotlin(): Call<List<PostKotlin>>


    @GET("/comments")
    abstract fun getComments(): Call<List<Comment>>
    */


}

