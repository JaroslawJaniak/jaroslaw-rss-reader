package pl.mobileappacademy.rssreader.di


import dagger.Component
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.di.modules.AppModule
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeViewModel
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeFragment
import javax.inject.Singleton

@Singleton


@Component(modules = [AppModule::class])

interface AppComponent {
    fun inject(into: App)
    fun inject(into: HomeFragment)
    fun inject(into: HomeViewModel)

}