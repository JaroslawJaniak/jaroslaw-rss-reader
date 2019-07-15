package pl.mobileappacademy.rssreader.models

import android.content.ClipData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

data class Description(

    @Element(name = "linkRSS")
    @ColumnInfo(name = "linkRSS")
    var linkRSS: String? = "",

    @Element(name = "itemRSS")
    @ColumnInfo(name = "itemRSS")
    var item: String? = ""
)
