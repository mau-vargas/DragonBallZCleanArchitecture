package com.example.dragonballz.data.repository

import com.example.dragonballz.core.funtional.Either
import com.example.dragonballz.core.platform.Failure
import com.example.dragonballz.data.remote.DragonBallApi
import com.example.dragonballz.data.remote.dto.Character
import com.example.dragonballz.data.remote.dto.CharacterListResponse
import com.example.dragonballz.data.remote.dto.CharacterResponse
import com.example.dragonballz.data.remote.dto.Links
import com.example.dragonballz.data.remote.dto.Meta
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.components.SingletonComponent
import retrofit2.Call
import javax.inject.Inject

class DragonBallRepositoryImpl @Inject constructor(
     private val api: DragonBallApi
) : DragonBallRepository {
     private val emptyCharacter = CharacterListResponse(items = emptyList(), meta = Meta(0, 0, 0, 0, 0), links = Links("", "", "", ""))

    override suspend fun getAllCharactersRemote(): Either<Failure, CharacterListResponse> {
       return request(
            api.getAllCharacters(),
            { it }, emptyCharacter
        )
    }



    private fun <T, R> request(
        call: Call<T>,
        transform: (T) -> R,
        default: T
    ): Either<Failure, R> {
        return try {
            val response = call.execute()
            when (response.isSuccessful) {
                true -> Either.Right(transform((response.body() ?: default)))
                false -> Either.Left(Failure.ServerError)
            }
        } catch (exception: Throwable) {
            Either.Left(Failure.ServerError)
        }
    }


}