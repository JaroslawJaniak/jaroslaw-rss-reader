package pl.mobileappacademy.rssreader.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import pl.mobileappacademy.rssreader.data.models.HomeItem

@Dao
interface PortalDao {

    @Query("SELECT * FROM portalTable")
    fun getAll(): LiveData<List<HomeItem>>?

    @Query("SELECT * from portalTable ORDER BY name ASC")
    fun sortByASCName(): LiveData<List<HomeItem>>

    @Query("SELECT * from portalTable ORDER BY name DESC")
    fun sortByDSCName(): LiveData<List<HomeItem>>

    @Query("SELECT * FROM portalTable WHERE id = :id")
    fun getById(id: Long): LiveData<HomeItem>

    @Insert(onConflict = REPLACE)
    fun insert(homeItem: HomeItem)

    @Update(onConflict = REPLACE)
    fun update(task: HomeItem)

    @Delete
    fun delete(portal: HomeItem)

    @Query("DELETE FROM portalTable WHERE id = :id")
    fun deletePortal(id: Long)

    @Query("DELETE FROM portalTable")
    fun deleteAll()
}