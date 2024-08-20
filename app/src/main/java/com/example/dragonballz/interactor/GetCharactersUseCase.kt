package com.example.dragonballz.interactor

import com.example.dragonballz.core.interactor.UseCase
import com.example.dragonballz.data.remote.dto.CharacterListResponse
import com.example.dragonballz.data.remote.dto.CharacterResponse
import com.example.dragonballz.data.repository.DragonBallRepository
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


class GetCharactersUseCase @Inject constructor(private val repository: DragonBallRepository) :
    UseCase<CharacterListResponse, GetCharactersUseCase.Params>() {

    override suspend fun run(params: Params) = repository.getAllCharactersRemote()

    data class Params(val id: Int)
}
