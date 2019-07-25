package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.HomeListItem

@Dao
interface ChannelsRssDao {

    @Query("SELECT * FROM channelsRssTable")
    fun getAllChannelsRss(): LiveData<List<HomeListItem>>?

    @Query("SELECT * from channelsRssTable ORDER BY name ASC")
    fun sortByNameChannelsRss(): LiveData<List<HomeListItem>>

    @Query("SELECT * FROM channelsRssTable WHERE id = :id")
    fun getByIdChannelsRss(id: Long): LiveData<HomeListItem>

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