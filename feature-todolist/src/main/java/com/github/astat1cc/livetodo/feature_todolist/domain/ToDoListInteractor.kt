package com.github.astat1cc.livetodo.feature_todolist.domain

import com.github.astat1cc.livetodo.core.ExceptionHandler
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoListResponseDomain

interface ToDoListInteractor {

    suspend fun fetchToDoList(): ToDoListResponseDomain

    class Impl(
        private val repository: ToDoListRepository,
        private val exceptionHandler: ExceptionHandler
    ) : ToDoListInteractor {

        override suspend fun fetchToDoList(): ToDoListResponseDomain =
            try {
                ToDoListResponseDomain.Success(repository.fetchToDoList())
            } catch (e: Exception) {
                ToDoListResponseDomain.Fail(exceptionHandler.defineErrorTypeOfException(e))
            }
    }
}