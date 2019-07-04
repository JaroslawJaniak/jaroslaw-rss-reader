package pl.mobileappacademy.rssreader.di.modules

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(val context: Context) {
    @Provides
    @Singleton
    fun provideContext(application: Application): Context {
        return application
    }
}