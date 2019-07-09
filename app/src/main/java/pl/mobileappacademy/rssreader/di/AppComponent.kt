package pl.mobileappacademy.rssreader.di


import dagger.Component
import pl.mobileappacademy.rssreader.App
import pl.mobileappacademy.rssreader.di.modules.AppModule
import pl.mobileappacademy.rssreader.fragments.OldFrgments.BlankFragment1
import pl.mobileappacademy.rssreader.fragments.OldFrgments.BlankFragment1ViewModel
import pl.mobileappacademy.rssreader.fragments.OldFrgments.BlankFragment2
import pl.mobileappacademy.rssreader.fragments.OldFrgments.BlankFragment2ViewModel
import javax.inject.Singleton

@Singleton


@Component(modules = [AppModule::class])

interface AppComponent {
    fun inject(into: App)
    fun inject(into: BlankFragment1)
    fun inject(into: BlankFragment1ViewModel)

    fun inject(into: BlankFragment2)
    fun inject(into: BlankFragment2ViewModel)
}