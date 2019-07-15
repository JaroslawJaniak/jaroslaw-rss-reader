package pl.mobileappacademy.rssreader.models

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element


data class Channel(

    @Element(name = "id")
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    var idCh: Int? = null,

    @Element(name = "descriptionCh")
    @ColumnInfo(name = "descriptionCh")
    var descriptionCh: DescriptionCh?,

    @Element(name = "itemCh")
    @ColumnInfo(name = "itemCh")
    var itemCh: ItemCh?
)
