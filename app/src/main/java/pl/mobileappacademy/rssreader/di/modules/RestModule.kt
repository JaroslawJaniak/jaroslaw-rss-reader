package pl.mobileappacademy.rssreader.di.modules

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import pl.mobileappacademy.rssreader.Retrofit.RetrofitService
import retrofit2.Retrofit
import javax.inject.Singleton

import retrofit2.converter.gson.GsonConverterFactory

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideGson() = Gson()

    @Provides
    @Singleton
    fun provideRetrofit(gson: Gson) : Retrofit {
        return Retrofit
            .Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create(gson)).build()
    }

    @Provides
    fun provideRestService(retrofit: Retrofit): RetrofitService {
        return retrofit.create(RetrofitService::class.java)
    }
}