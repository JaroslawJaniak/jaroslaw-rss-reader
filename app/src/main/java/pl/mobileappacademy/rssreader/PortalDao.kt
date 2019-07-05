package pl.mobileappacademy.rssreader

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import pl.mobileappacademy.rssreader.models.Portal
import retrofit2.http.Query

@Dao
interface PortalDao {
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

    @Insert
    fun insertAll(vararg portals: Portal)

    @Delete
    fun delete(portal: Portal)
}