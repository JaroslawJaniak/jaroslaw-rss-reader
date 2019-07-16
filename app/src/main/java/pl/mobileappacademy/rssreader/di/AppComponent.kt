package pl.mobileappacademy.rssreader.di


import dagger.Component
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.di.modules.AppModule
import pl.mobileappacademy.rssreader.di.modules.RestModule
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeViewModel
import pl.mobileappacademy.rssreader.fragments.HomeFragments.HomeFragment
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelFragment
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelViewModel
import javax.inject.Singleton

@Singleton

@Component(modules = [AppModule::class, RestModule::class])

interface AppComponent {
    fun inject(into: App)
    fun inject(into: HomeFragment)
    fun inject(into: HomeViewModel)
    fun inject(into: ChannelFragment)
    fun inject(into: ChannelViewModel)

}