package pl.mobileappacademy.rssreader.models.rssModels

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root
import pl.mobileappacademy.rssreader.models.rssModels.Channel

@Root(name = "rss", strict = false)
class Rss (
    @Element(name = "channel")
    var channel: Channel? = null
)