package pl.mobileappacademy.rssreader.models

import android.content.ClipData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

data class DescriptionCh(

    @Element(name = "linkDescription")
    @ColumnInfo(name = "linkDescription")
    var linkDescription: String? = "",

    @Element(name = "itemDescription")
    @ColumnInfo(name = "itemDescription")
    var itemDescription: ItemCh?
)
