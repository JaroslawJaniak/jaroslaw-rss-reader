package pl.mobileappacademy.rssreader.AppDatabase;


import androidx.room.Database;
import androidx.room.RoomDatabase;
import pl.mobileappacademy.rssreader.fragments.New_Fragments.HomeItem;


@Database(entities = {HomeItem.class}, version = 2)

public abstract class AppDatabase extends RoomDatabase {

}