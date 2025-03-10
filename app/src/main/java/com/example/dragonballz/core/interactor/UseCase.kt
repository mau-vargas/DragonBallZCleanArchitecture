package com.example.dragonballz.core.interactor

import com.example.dragonballz.core.funtional.Either
import com.example.dragonballz.core.platform.Failure
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(
        params: Params,
        scope: CoroutineScope = MainScope(),
        onResult: (Either<Failure, Type>) -> Unit = {}
    ) {
        scope.launch {
            val deferredJob = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferredJob.await())
        }
    }

    /**
     * Helper class to represent Empty
     * Params when a use case does not
     * need them.
     *
     * @see UseCase
     */
    class None
}
