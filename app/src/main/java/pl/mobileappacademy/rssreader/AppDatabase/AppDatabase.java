package pl.mobileappacademy.rssreader.AppDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import pl.mobileappacademy.rssreader.models.Portal;

@Database(entities = {Portal.class}, version = 2)
//@TypeConverters(DateConverter.class)


public abstract class AppDatabase extends RoomDatabase {

    //private static AppDatabase INSTANCE;

    //public abstract PortalDao portalDao();
}