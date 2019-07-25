package pl.mobileappacademy.rssreader.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

@Entity(tableName = "channelsRssTable")
data class HomeListItem(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "name")
    var name: String? = "",

    @ColumnInfo(name = "imagePath")
    var imagePath: String? = "",

    @ColumnInfo(name = "adress")
    var adress: String? = "",

    var portalName: String? = ""
)