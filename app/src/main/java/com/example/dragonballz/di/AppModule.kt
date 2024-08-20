package com.example.dragonballz.di

import com.example.dragonballz.data.remote.DragonBallApi
import com.example.dragonballz.data.repository.DragonBallRepository
import com.example.dragonballz.data.repository.DragonBallRepositoryImpl
import com.example.dragonballz.interactor.GetCharactersUseCase
//import com.example.dragonballz.interactor.GetCharactersUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private const val BASE_URL = "https://dragonball-api.com/"

    @Provides
    @Singleton
    fun dragonBallApi(): DragonBallApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(DragonBallApi::class.java)
    }


    @Provides
    @Singleton
    fun provideDragonBallRepository(api: DragonBallApi): DragonBallRepository {
        return DragonBallRepositoryImpl(api)
    }


    @Provides
    @Singleton
    fun provideGetCharactersUseCase(repository: DragonBallRepository): GetCharactersUseCase {
        return GetCharactersUseCase(repository)
    }

}