package pl.mobileappacademy.rssreader.Retrofit;

import android.app.Application
import pl.mobileappacademy.rssreader.di.AppComponent
import pl.mobileappacademy.rssreader.di.DaggerAppComponent
import pl.mobileappacademy.rssreader.di.modules.AppModule


public class App : Application() {

        val component: AppComponent by lazy {
        DaggerAppComponent
        .builder()
        .appModule(AppModule(this))
        .build()
        }

        override fun onCreate() {
        super.onCreate()
        //component.inject(this)
        }
        }