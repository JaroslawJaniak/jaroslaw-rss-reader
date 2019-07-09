package pl.mobileappacademy.rssreader.appDatabase

import androidx.lifecycle.LiveData
import androidx.room.*
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeItem

@Dao
interface PortalDao {

    @Query("SELECT * FROM homeItemsTableName")
    fun getAll(): LiveData<List<HomeItem>>

    @Query("SELECT * FROM homeItemsTableName WHERE id = :id")
    fun getById(id: Long): LiveData<HomeItem>

    @Insert
    fun insertAll(vararg homeItem: HomeItem)

    @Update
    fun update(task: HomeItem)

    @Delete
    fun delete(portal: HomeItem)
}