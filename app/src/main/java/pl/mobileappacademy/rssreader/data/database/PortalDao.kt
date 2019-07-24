package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.HomeItem
import pl.mobileappacademy.rssreader.data.models.HomeListItem

@Dao
interface PortalDao {

    @Query("SELECT * FROM homeItemsTable")
    fun getAll(): LiveData<List<HomeItem>>?

    @Query("SELECT * FROM homeListItemsTable")
    fun getAllRss(): LiveData<List<HomeListItem>>?

    @Query("SELECT * from homeItemsTable ORDER BY name ASC")
    fun getByName(): LiveData<List<HomeItem>>

    @Query("SELECT * FROM homeItemsTable WHERE id = :id")
    fun getById(id: Long): LiveData<HomeItem>

    @Insert(onConflict = REPLACE)
    fun insert(homeItem: HomeItem)

    @Insert(onConflict = REPLACE)
    fun insertPortal(homeListItem: HomeListItem)

    @Update
    fun update(task: HomeItem)

    @Delete
    fun delete(portal: HomeItem)

    @Query("DELETE FROM homeItemsTable WHERE id = :id")
    fun deletePortal(id: Long)

    @Query("DELETE FROM homeItemsTable")
    fun deleteAll()
}