package com.example.dragonballz.data.repository

import com.example.dragonballz.core.funtional.Either
import com.example.dragonballz.core.platform.Failure
import com.example.dragonballz.data.remote.dto.CharacterListResponse
import com.example.dragonballz.data.remote.dto.CharacterResponse


interface DragonBallRepository {
    suspend fun getAllCharactersRemote(): Either<Failure, CharacterListResponse>
}