package pl.mobileappacademy.rssreader;

import android.app.Application


class App : Application() {

    override fun onCreate() {
        super.onCreate()
        Injector.reInit(this)
    }
}