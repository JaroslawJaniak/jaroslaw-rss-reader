package pl.mobileappacademy.rssreader.data.models.rssModels

import androidx.room.*
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import pl.mobileappacademy.rssreader.presentation.activities.base.customViews.GithubTypeConverters

@Entity(tableName = "channelXmlTable")
@Root(name = "channel", strict = false)
data class Channel(

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @ColumnInfo(name = "title")
    @field:Element(name = "title")
    var title: String? = "",

    @ColumnInfo(name = "description")
    @field:Element(name = "description", required = false)
    var description: String? = "",

    @ColumnInfo(name = "items")
    @field:ElementList(inline = true, required = false)
    @TypeConverters(GithubTypeConverters::class)
    var items: List<Item>? = null,

    @ColumnInfo(name = "portalName")
    var portalName: String? = ""
)

