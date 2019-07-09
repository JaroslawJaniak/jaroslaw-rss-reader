package pl.mobileappacademy.rssreader.fragments.New_Fragments

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class MovieInfo (
    @SerializedName("id")
    var id: Long  = -1,
    @SerializedName("title")
    var title: String = "",
    @SerializedName("overview")
    var overview: String = "",
    @SerializedName("voteCount")
    var voteCount: Int = 0,
    @SerializedName("posterPath")
    var posterPath: String? = "",
    @SerializedName("voteAverage")
    var voteAverage: Double = 0.0
) : Serializable