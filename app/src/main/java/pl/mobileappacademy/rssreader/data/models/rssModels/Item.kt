package pl.mobileappacademy.rssreader.data.models.rssModels

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Entity(tableName = "itemsChannelXmlTable")
@Root(name = "item", strict = false)
data class Item(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "title")
    @field:Element(name = "title", required = false)
    var title: String? = "",

    @ColumnInfo(name = "description")
    @field:Element(name = "description")
    var description: String? = "",

    @ColumnInfo(name = "link")
    @field:Element(name = "link")
    var link: String? = "",

    @ColumnInfo(name = "pubDate")
    @field:Element(name = "pubDate")
    var pubDate: String? = "",

    @ColumnInfo(name = "category")
    var category : String? = "",

    @ColumnInfo(name = "portalName")
    var portalName: String? = ""


)