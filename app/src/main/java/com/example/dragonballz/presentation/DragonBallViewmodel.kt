package com.example.dragonballz.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dragonballz.core.platform.BaseViewModel
import com.example.dragonballz.data.remote.dto.CharacterListResponse
import com.example.dragonballz.data.remote.dto.CharacterResponse
import com.example.dragonballz.interactor.GetCharactersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class DragonBallViewmodel @Inject constructor(private val getCharacters: GetCharactersUseCase) :
    BaseViewModel() {


    fun getAllCharacters() =
        getCharacters(GetCharactersUseCase.Params(1), viewModelScope) {
            it.fold(::handleFailure, ::handleCharacters)
        }


    private fun handleCharacters(characterResponse: CharacterListResponse) {
        Log.e("", "")
    }


}