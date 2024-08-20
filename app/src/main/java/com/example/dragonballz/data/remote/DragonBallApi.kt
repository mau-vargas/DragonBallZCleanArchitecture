package com.example.dragonballz.data.remote

import com.example.dragonballz.data.remote.dto.CharacterListResponse
import com.example.dragonballz.data.remote.dto.CharacterResponse
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import retrofit2.http.GET


interface  DragonBallApi {

    @GET("api/characters")
     fun getAllCharacters(): Call<CharacterListResponse>

}