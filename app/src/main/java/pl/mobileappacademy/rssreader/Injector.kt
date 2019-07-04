package pl.mobileappacademy.rssreader

import android.app.Application
import pl.mobileappacademy.rssreader.di.AppComponent
import pl.mobileappacademy.rssreader.di.DaggerAppComponent
import pl.mobileappacademy.rssreader.di.modules.AppModule


object Injector {

    lateinit var component: AppComponent

    fun reInit(application: Application) {
        component = DaggerAppComponent
            .builder()
            .appModule(AppModule(application))
            .build()
    }
}