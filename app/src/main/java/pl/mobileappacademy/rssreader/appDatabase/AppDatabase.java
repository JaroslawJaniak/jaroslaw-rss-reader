package pl.mobileappacademy.rssreader.appDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeItem;


@Database(entities = {HomeItem.class}, version = 2)

public abstract class AppDatabase extends RoomDatabase {

}