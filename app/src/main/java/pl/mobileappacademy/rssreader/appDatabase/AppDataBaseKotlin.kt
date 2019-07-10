package pl.mobileappacademy.rssreader.appDatabase


import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pl.mobileappacademy.rssreader.models.HomeItem
import java.time.chrono.HijrahChronology.INSTANCE


@Database(
    version = 2,
    entities = [HomeItem::class],
    exportSchema = false
)
abstract class AppDataBaseKotlin : RoomDatabase() {

    abstract fun homeDao(): PortalDao

    companion object {

        @Volatile
        lateinit var appDataBase: AppDataBaseKotlin

        fun getDatabase(context: Context): AppDataBaseKotlin {

            synchronized(this)
            {
                appDataBase = Room
                    .databaseBuilder(context, AppDataBaseKotlin::class.java, "HomeDataBase")
                    .fallbackToDestructiveMigration()
                    .build()

                return appDataBase
            }
        }

        val portalDao get() = appDataBase.homeDao()
    }


    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        @RequiresApi(Build.VERSION_CODES.O)
        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch(Dispatchers.IO) {
                    populateDatabase(appDataBase.homeDao())
                }
            }
        }

        fun populateDatabase(portalDao: PortalDao) {
            portalDao.deleteAll()

            var portal = HomeItem(
                11,
                "A -> tvn24",
                "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
                "https://www.tvn24.pl/rss.html"
            )
            portalDao.insert(portal)

            portal = HomeItem(
                12,
                "B -> tvn24",
                "https://www.rmf24.pl/s/classic/Small-rmf24.pl.png",
                "https://www.tvn24.pl/rss.html"
            )

            portalDao.insert(portal)
        }
    }
    
}