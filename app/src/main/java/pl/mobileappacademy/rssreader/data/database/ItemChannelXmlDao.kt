package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.rssModels.Item

@Dao
interface ItemChannelXmlDao {

    @Query("SELECT * FROM portalTable")
    fun getAllItemChannelXml(): LiveData<List<Item>>?

    @Query("SELECT * from portalTable ORDER BY name ASC")
    fun sortByNameItemChannelXml(): LiveData<List<Item>>

    @Query("SELECT * FROM portalTable WHERE id = :id")
    fun getByIdItemChannelXml(id: Long): LiveData<Item>

    @Insert(onConflict = REPLACE)
    fun insertItemChannelXml(itemXml: Item)

    @Update
    fun updateItemChannelXml(task: Item)

    @Delete
    fun deleteItemChannelXml(itemXml: Item)

    @Query("DELETE FROM portalTable WHERE id = :id")
    fun deleteItemChannelXml2(id: Long)

    @Query("DELETE FROM portalTable")
    fun deleteAllItemChannelXml()
}