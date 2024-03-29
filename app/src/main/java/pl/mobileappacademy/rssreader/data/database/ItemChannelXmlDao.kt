package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.rssModels.Item

@Dao
interface ItemChannelXmlDao {

    @Query("SELECT * FROM itemsChannelXmlTable")
    fun getAllItemChannelXml(): LiveData<List<Item>>?

    @Query("SELECT * from itemsChannelXmlTable WHERE portalName = :portalName ORDER BY category ASC")
    fun sortByNameASCItemChannelXml(portalName: String?): LiveData<List<Item>>

    @Query("SELECT * from itemsChannelXmlTable WHERE portalName = :portalName ORDER BY category DESC")
    fun sortByNameDSCItemChannelXml(portalName: String?): LiveData<List<Item>>

    @Query("SELECT * FROM itemsChannelXmlTable WHERE portalName = :portalName AND category = :channelName")
    fun getByPortalNameItemChannelXml(portalName: String?, channelName: String?): LiveData<List<Item>>

    @Query("SELECT * FROM itemsChannelXmlTable WHERE portalName = :portalName")
    fun getAllByPortalNameItemChannelXml(portalName: String?): LiveData<List<Item>>

    @Query("SELECT * FROM itemsChannelXmlTable WHERE id = :id")
    fun getByIdItemChannelXml(id: Long): LiveData<List<Item>>

    @Insert(onConflict = REPLACE)
    fun insertItemChannelXml(itemXml: Item)

    @Update(onConflict = REPLACE)
    fun updateItemChannelXml(taskItem: Item)

    @Delete
    fun deleteItemChannelXml(itemXml: Item)

    @Query("DELETE FROM itemsChannelXmlTable WHERE id = :id")
    fun deleteItemChannelXml2(id: Long)

    @Query("DELETE FROM itemsChannelXmlTable")
    fun deleteAllItemChannelXml()
}