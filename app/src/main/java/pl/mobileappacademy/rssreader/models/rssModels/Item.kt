package pl.mobileappacademy.rssreader.models.rssModels

import androidx.room.PrimaryKey
import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "item", strict = false)
class Item(

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,

    @Element(name = "title")
    var title: String? = "",

    @Element(name = "description")
    var description: String? = "",

    @Element(name = "link")
    var link: String? = "",

    @Element(name = "pubDate")
    var pubDate: String? = ""


)