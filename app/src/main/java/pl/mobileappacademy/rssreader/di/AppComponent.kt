package pl.mobileappacademy.rssreader.di


import dagger.Component
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.di.modules.AppModule
import pl.mobileappacademy.rssreader.di.modules.RestModule
import pl.mobileappacademy.rssreader.presentation.fragments.RSSFragments.ChannelDetailesFragment
import pl.mobileappacademy.rssreader.presentation.fragments.RSSFragments.ChannelDetailesViewModel
import pl.mobileappacademy.rssreader.presentation.fragments.homeFragments.HomeViewModel
import pl.mobileappacademy.rssreader.presentation.fragments.homeFragments.HomeFragment
import pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments.RssChannelsFragment
import pl.mobileappacademy.rssreader.presentation.fragments.rssChannelsFragments.RssChannelsViewModel
import pl.mobileappacademy.rssreader.presentation.fragments.RSSFragments.ChannelFragment
import pl.mobileappacademy.rssreader.presentation.fragments.RSSFragments.ChannelViewModel
import javax.inject.Singleton

@Singleton

@Component(modules = [AppModule::class, RestModule::class])

interface AppComponent {
    fun inject(into: App)
    fun inject(into: HomeFragment)
    fun inject(into: HomeViewModel)
    fun inject(into: ChannelFragment)
    fun inject(into: ChannelViewModel)
    fun inject(into: ChannelDetailesFragment)
    fun inject(into: ChannelDetailesViewModel)
    fun inject(into: RssChannelsFragment)
    fun inject(into: RssChannelsViewModel)
}