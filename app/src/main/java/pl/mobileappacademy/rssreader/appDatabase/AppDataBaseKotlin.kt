package pl.mobileappacademy.rssreader.appDatabase


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.mobileappacademy.rssreader.models.HomeItem


@Database(
    version = 3,
    entities = [HomeItem::class]
)
abstract class AppDataBaseKotlin : RoomDatabase() {

    abstract fun portalDao(): PortalDao


    companion object {
        var INSTANCE: AppDataBaseKotlin? = null

        fun getAppDataBaseKotlin(context: Context): AppDataBaseKotlin? {
            if (INSTANCE == null) {
                synchronized(AppDataBaseKotlin::class) {
                    INSTANCE =
                        Room.databaseBuilder(context.applicationContext, AppDataBaseKotlin::class.java, "portal")
                            .build()
                }
            }
            return INSTANCE
        }

        fun destroyAppDataBaseKotlin() {
            INSTANCE = null
        }
    }

}