package pl.mobileappacademy.rssreader.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import retrofit2.Retrofit
import javax.inject.Singleton

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://www.tvn24.pl/")
            .addConverterFactory(SimpleXmlConverterFactory.create()).build()
    }

    @Provides
    fun provideRestService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}