package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.Portal

@Dao
interface ChannelsRssDao {

    @Query("SELECT * FROM channelsRssTable")
    fun getAllChannelsRss(): LiveData<List<Portal>>?

    @Query("SELECT * from channelsRssTable WHERE portalName = :portalName ORDER BY name ASC")
    fun sortByNameASCChannelsRss(portalName: String?): LiveData<List<Portal>>

    @Query("SELECT * from channelsRssTable WHERE portalName = :portalName ORDER BY name DESC")
    fun sortByNameDSCChannelsRss(portalName: String?): LiveData<List<Portal>>

    @Query("SELECT * FROM channelsRssTable WHERE id = :id")
    fun getByIdChannelsRss(id: Long): LiveData<Portal>

    @Query("SELECT * FROM channelsRssTable WHERE portalName = :portalName")
    fun getByPortalNameChannelsRss(portalName: String?): LiveData<List<Portal>>

    @Query("SELECT COUNT(id) FROM channelsRssTable")
    fun getCount(): Int

    @Insert(onConflict = REPLACE)
    fun insertChannelsRss(portal: Portal)

    @Update
    fun updateChannelsRss(task: Portal)

    @Delete
    fun deleteChannelsRss(channelRss: Portal)

    @Query("DELETE FROM channelsRssTable WHERE id = :id")
    fun deleteChannelsRssQuery(id: Long)

    @Query("DELETE FROM channelsRssTable")
    fun deleteAllChannelsRss()
}