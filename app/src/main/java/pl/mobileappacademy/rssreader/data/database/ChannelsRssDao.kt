package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.HomeListItem

@Dao
interface ChannelsRssDao {

    @Query("SELECT * FROM channelsRssTable")
    fun getAllChannelsRss(): List<HomeListItem>?

    @Query("SELECT * from channelsRssTable WHERE portalName = :portalName ORDER BY name ASC")
    fun sortByNameASCChannelsRss(portalName: String?): LiveData<List<HomeListItem>>

    @Query("SELECT * from channelsRssTable WHERE portalName = :portalName ORDER BY name DESC")
    fun sortByNameDSCChannelsRss(portalName: String?): LiveData<List<HomeListItem>>

    @Query("SELECT * FROM channelsRssTable WHERE id = :id")
    fun getByIdChannelsRss(id: Long): LiveData<HomeListItem>

    @Query("SELECT * FROM channelsRssTable WHERE portalName = :portalName")
    fun getByPortalNameChannelsRss(portalName: String?): LiveData<List<HomeListItem>>

    @Query("SELECT COUNT(id) FROM channelsRssTable")
    fun getCount(): Int

    @Insert(onConflict = REPLACE)
    fun insertChannelsRss(homeListItem: HomeListItem)

    @Update
    fun updateChannelsRss(task: HomeListItem)

    @Delete
    fun deleteChannelsRss(channelRss: HomeListItem)

    @Query("DELETE FROM channelsRssTable WHERE id = :id")
    fun deleteChannelsRssQuery(id: Long)

    @Query("DELETE FROM channelsRssTable")
    fun deleteAllChannelsRss()
}