package pl.mobileappacademy.rssreader.data.models.rssModels

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Rss (
    //@field:Element(name = "channel")
    //var channel: Channel? = null

    @field:ElementList(inline = true, required = false)
    var channels: List<Channel>? = null
)