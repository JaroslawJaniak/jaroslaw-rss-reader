package pl.mobileappacademy.rssreader.AppDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import pl.mobileappacademy.rssreader.PortalDao;
import pl.mobileappacademy.rssreader.models.Portal;

import static com.google.gson.internal.$Gson$Types.arrayOf;

@Database(entities = {Portal.class}, version = 2)
//@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase {

    //private static PortalsDatabase INSTANCE;

    public abstract PortalDao portalDao();
}