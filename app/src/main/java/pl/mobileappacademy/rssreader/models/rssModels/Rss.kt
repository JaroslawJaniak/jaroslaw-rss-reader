package pl.mobileappacademy.rssreader.models.rssModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import pl.mobileappacademy.rssreader.models.rssModels.Channel

@Root(name = "rss", strict = false)
data class Rss (
    //@field:Element(name = "channel")
    //var channel: Channel? = null

    @field:ElementList(inline = true, required = false)
    var channels: List<Channel>? = null
)