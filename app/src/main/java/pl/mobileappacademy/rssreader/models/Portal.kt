package pl.mobileappacademy.rssreader.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

@Entity(tableName = "portals")
data class Portal(

    @PrimaryKey val id: Int? = -1,

    @Element(name = "name")
    @ColumnInfo(name = "name")
    var name: String? = "",


    @Element(name = "imageUrl")
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String? = ""

)