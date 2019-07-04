package pl.mobileappacademy.rssreader.models

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root


@Root(name = "item", strict = false)

data class Article (

    @Element(name = "title")
    var title: String? = null,

    @Element(name = "link")
    var link: String? = null,

    @Element(name = "description")
    var description: String? = null
)