package pl.mobileappacademy.rssreader;

import android.app.Application
import pl.mobileappacademy.rssreader.data.database.AppDataBaseKotlin


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.reInit(this)
        AppDataBaseKotlin.getAppDataBaseKotlin(this)

    }
}