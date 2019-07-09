package pl.mobileappacademy.rssreader.fragments.New_Fragments

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Movie(
    @SerializedName("info")
    var info: MovieInfo = MovieInfo()
) : Serializable