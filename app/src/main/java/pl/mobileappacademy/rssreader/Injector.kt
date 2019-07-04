package pl.mobileappacademy.rssreader

import pl.mobileappacademy.rssreader.di.AppComponent
import pl.mobileappacademy.rssreader.di.DaggerAppComponent


object Injector {
    init {
        reInit()
    }

    fun reInit() {
        component = DaggerAppComponent
            .builder()
            .build()
    }

    lateinit var component: AppComponent

}