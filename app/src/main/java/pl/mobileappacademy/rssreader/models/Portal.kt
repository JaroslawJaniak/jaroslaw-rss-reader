package pl.mobileappacademy.rssreader.models

import android.media.Image
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.simpleframework.xml.Element

@Entity(tableName = "portals")
data class Portal(

    @PrimaryKey val id: Int? = -1,

    @Element(name = "name")
    @ColumnInfo(name = "name")
    var name: String? = "",
/*
    @Element(name = "imageResource")
    @ColumnInfo(name = "imageResource")
    var imageResource: Image?,

    @Element(name = "isFavorite")
    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean = false,

*/

    @Element(name = "imageUrl")
    @ColumnInfo(name = "imageUrl")
    var imageUrl: String? = ""

)

/*
@Entity
data class User(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "first_name") val firstName: String?,
    @ColumnInfo(name = "last_name") val lastName: String?
)
*/