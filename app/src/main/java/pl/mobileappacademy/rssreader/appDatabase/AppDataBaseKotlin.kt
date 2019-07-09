package pl.mobileappacademy.rssreader.appDatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeItem


@Database(
    version = 2,
    entities = [HomeItem::class],
    exportSchema = false
)
abstract class AppDataBaseKotlin : RoomDatabase() {
    abstract fun getHomeDao(): PortalDao

    companion object {
        lateinit var appDataBase: AppDataBaseKotlin
        fun init(context: Context) {
            appDataBase = Room
                .databaseBuilder(context, AppDataBaseKotlin::class.java, "HomeDataBase")
                .fallbackToDestructiveMigration()
                .build()
        }

        val portalDao
            get() = appDataBase.getHomeDao()
    }
}