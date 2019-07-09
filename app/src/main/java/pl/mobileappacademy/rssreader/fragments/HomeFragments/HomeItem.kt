package pl.mobileappacademy.rssreader.fragments.New_Fragments

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

@Entity(tableName = "portals")
data class HomeItem(

    @PrimaryKey val id: Int? = -1,

    @Element(name = "name")
    @ColumnInfo(name = "name")
    var name: String? = "",

    @Element(name = "imagePath")
    @ColumnInfo(name = "imagePath")
    var imagePath: String? = ""

)
