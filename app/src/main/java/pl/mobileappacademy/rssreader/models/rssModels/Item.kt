package pl.mobileappacademy.rssreader.models.rssModels

import androidx.room.PrimaryKey
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
data class Item(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @field:Element(name = "title", required = false)
    var title: String? = "",

    @field:Element(name = "description")
    var description: String? = "",

    @field:Element(name = "link")
    var link: String? = "",

    @field:Element(name = "pubDate")
    var pubDate: String? = "",

    var category :String? = ""


)