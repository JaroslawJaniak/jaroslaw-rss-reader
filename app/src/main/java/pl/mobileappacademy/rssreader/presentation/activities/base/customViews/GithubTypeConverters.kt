package pl.mobileappacademy.rssreader.presentation.activities.base.customViews

import androidx.room.TypeConverter
import com.google.gson.reflect.TypeToken
import com.google.gson.Gson
import pl.mobileappacademy.rssreader.data.models.rssModels.Item
import java.util.*


class GithubTypeConverters {

    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<Item> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<Item>>() {

        }.type

        return gson.fromJson<List<Item>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<Item>): String {
        return gson.toJson(someObjects)
    }
}