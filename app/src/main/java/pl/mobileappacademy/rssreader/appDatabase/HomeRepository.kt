package pl.mobileappacademy.rssreader.base

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import pl.mobileappacademy.rssreader.appDatabase.PortalDao
import pl.mobileappacademy.rssreader.models.HomeItem

class HomeRepository(private val portalDao: PortalDao) {

    val allPortals: LiveData<List<HomeItem>> = portalDao.getAll()
    val allPortalsByName: LiveData<List<HomeItem>> = portalDao.getByName()

    @WorkerThread
    fun insert(portal: HomeItem) {
        portalDao.insert(portal)
    }

}