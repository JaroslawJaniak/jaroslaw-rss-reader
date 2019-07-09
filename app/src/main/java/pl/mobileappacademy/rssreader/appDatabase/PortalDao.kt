package pl.mobileappacademy.rssreader.appDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeItem
import pl.mobileappacademy.rssreader.models.Portal

@Dao
interface PortalDao {

    @Query("SELECT * FROM portals")
    fun getAll(): LiveData<List<HomeItem>>

    @androidx.room.Query("SELECT * FROM portals WHERE id = :id")
    fun getById(id: Long): LiveData<HomeItem>

    @Insert
    fun insertAll(vararg portals: Portal)

    @Update
    fun update(task: Portal)

    @Delete
    fun delete(portal: Portal)
}