package pl.mobileappacademy.rssreader.di


import dagger.Component
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.di.modules.AppModule
import pl.mobileappacademy.rssreader.di.modules.RestModule
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelDetailesFragment
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelDetailesViewModel
import pl.mobileappacademy.rssreader.fragments.homeFragments.HomeViewModel
import pl.mobileappacademy.rssreader.fragments.homeFragments.HomeFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsFragment
import pl.mobileappacademy.rssreader.fragments.rssChannelsFragments.RssChannelsViewModel
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelFragment
import pl.mobileappacademy.rssreader.fragments.RSSFragments.ChannelViewModel
import pl.mobileappacademy.rssreader.fragments.dialogs.DialogFilterFragment
import pl.mobileappacademy.rssreader.fragments.dialogs.DialogFilterViewModel
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
    fun inject(into: DialogFilterFragment)
    fun inject(into: DialogFilterViewModel)


}