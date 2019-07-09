package pl.mobileappacademy.rssreader.AppDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.mobileappacademy.rssreader.models.Portal

@Dao
interface PortalDao {

    @Query("SELECT * FROM portals")
    fun getAll(): LiveData<List<Portal>>

    @androidx.room.Query("SELECT * FROM portals WHERE id = :id")
    fun getById(id: Long): LiveData<Portal>

    @Insert
    fun insertAll(vararg portals: Portal)

    @Update
    fun update(task: Portal)

    @Delete
    fun delete(portal: Portal)
}