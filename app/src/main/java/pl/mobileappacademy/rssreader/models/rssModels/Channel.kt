package pl.mobileappacademy.rssreader.models.rssModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel(

    @field:Element(name = "title")
    var title: String? = "",

    @field:Element(name = "description", required = false)
    var description: String? = "",

    @field:ElementList(inline = true, required = false)
    var items: List<Item>? = null
)