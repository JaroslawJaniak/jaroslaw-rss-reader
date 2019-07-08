package pl.mobileappacademy.rssreader.AppDatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.mobileappacademy.rssreader.models.Portal


@Database(
    version = 1,
    entities = [Portal::class],
    exportSchema = false
)
abstract class AppDataBaseKotlin : RoomDatabase() {
    abstract fun getNoteDao(): PortalDao

    companion object {
        lateinit var appDataBase: AppDataBaseKotlin
        fun init(context: Context) {
            appDataBase = Room
                .databaseBuilder(context, AppDataBaseKotlin::class.java, "portalDataBase")
                .fallbackToDestructiveMigration()
                .build()
        }

        val portalDao
            get() = appDataBase.getNoteDao()
    }
}