package pl.mobileappacademy.rssreader.models.rssModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
class Channel(

    @Element(name = "title")
    var title: String? = "",

    @Element(name = "description")
    var description: String? = "",

    @Element(name = "items")
    var items: List<Item>? = null
)