package pl.mobileappacademy.rssreader.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import pl.mobileappacademy.rssreader.data.models.HomeItem
import pl.mobileappacademy.rssreader.data.models.HomeListItem


@Database(
    version = 1,
    entities = [HomeItem::class, HomeListItem::class]
)
abstract class AppDataBaseKotlin : RoomDatabase() {

    abstract fun portalDao(): PortalDao

    companion object {
        var appDb: AppDataBaseKotlin? = null

        fun getAppDataBaseKotlin(context: Context): AppDataBaseKotlin? {
            if (appDb == null) {
                synchronized(AppDataBaseKotlin::class) {
                    appDb =
                        Room.databaseBuilder(context.applicationContext, AppDataBaseKotlin::class.java, "appDatabase")
                            .build()
                }
            }
            return appDb
        }
    }

}