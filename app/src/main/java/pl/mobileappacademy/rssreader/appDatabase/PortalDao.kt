package pl.mobileappacademy.rssreader.appDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.models.HomeItem

@Dao
interface PortalDao {

    @Query("SELECT * FROM homeItemsTable")
    fun getAll(): LiveData<List<HomeItem>>?

    @Query("SELECT * from homeItemsTable ORDER BY name ASC")
    fun getByName(): LiveData<List<HomeItem>>

    @Query("SELECT * FROM homeItemsTable WHERE id = :id")
    fun getById(id: Long): LiveData<HomeItem>

    @Insert(onConflict = REPLACE)
    fun insert(homeItem: HomeItem)

    @Update
    fun update(task: HomeItem)

    @Delete
    fun delete(portal: HomeItem)

    @Query("DELETE FROM homeItemsTable")
    fun deleteAll()
}