package pl.mobileappacademy.rssreader.di.modules

import dagger.Module
import dagger.Provides
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://google.pl/")
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideRestService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}