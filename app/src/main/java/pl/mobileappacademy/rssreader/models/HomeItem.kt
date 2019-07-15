package pl.mobileappacademy.rssreader.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

@Entity(tableName = "homeItemsTable")
data class HomeItem(

    @Element(name = "id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @Element(name = "name")
    @ColumnInfo(name = "name")
    var name: String? = "",

    @Element(name = "imagePath")
    @ColumnInfo(name = "imagePath")
    var imagePath: String? = "",

    @Element(name = "adress")
    @ColumnInfo(name = "adress")
    var adress: String? = "",

    @Element(name = "category")
    @ColumnInfo(name = "category")
    var category: String? = ""
)