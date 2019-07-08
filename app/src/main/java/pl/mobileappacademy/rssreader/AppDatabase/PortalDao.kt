package pl.mobileappacademy.rssreader.AppDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import pl.mobileappacademy.rssreader.models.Portal
import retrofit2.http.Query

@Dao
interface PortalDao {

    @androidx.room.Query("SELECT * FROM portals")
    fun getAll(): LiveData<List<Portal>>

    @androidx.room.Query("SELECT * FROM portals WHERE id = :id")
    fun getById(id: Long): LiveData<Portal>
/*
    @androidx.room.Query("SELECT * FROM portals WHERE name LIKE : first LIMIT 1")
    fun getByName(id: Long): LiveData<Portal>
*/
    @Insert
    fun insertAll(vararg portals: Portal)

    @Update
    fun update(task: Portal)

    @Delete
    fun delete(portal: Portal)


    /*@Query("SELECT * FROM user")
    fun getAll(): List<Portal>

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    fun loadAllByIds(userIds: IntArray): List<Portal>

    @Query("SELECT * FROM portal WHERE first_name LIKE :first AND " +
            "last_name LIKE :last LIMIT 1")
    fun findByName(first: String, last: String): Portal

    @Query(“SELECT * FROM Portals”)
    List<Portal> getPortals();
*/
}