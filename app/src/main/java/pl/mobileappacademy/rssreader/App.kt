package pl.mobileappacademy.rssreader;

import android.app.Application
import pl.mobileappacademy.rssreader.appDatabase.AppDataBaseKotlin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.reInit(this)
        AppDataBaseKotlin.getAppDataBaseKotlin(this)
    }
}