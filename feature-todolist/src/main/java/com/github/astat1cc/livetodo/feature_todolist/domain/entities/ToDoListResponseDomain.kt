package com.github.astat1cc.livetodo.feature_todolist.domain.entities

import com.github.astat1cc.livetodo.core.ErrorType
import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoListResponseDomainToUiMapper

sealed class ToDoListResponseDomain<ResponseUi : ToDoListResponseUi, EntityUi : ToDoUiModel> :
    Abstract.Object<ResponseUi, ToDoListResponseDomainToUiMapper<ResponseUi, EntityUi>> {

    class Success<ResponseUi : ToDoListResponseUi, EntityUi : ToDoUiModel>(
        private val toDoList: List<ToDoDomain<EntityUi>>
    ) : ToDoListResponseDomain<ResponseUi, EntityUi>() {

        override fun map(mapper: ToDoListResponseDomainToUiMapper<ResponseUi, EntityUi>): ResponseUi =
            mapper.map(toDoList)
    }

    class Fail<ResponseUi : ToDoListResponseUi, EntityUi : ToDoUiModel>(
        private val errorType: ErrorType
    ) : ToDoListResponseDomain<ResponseUi, EntityUi>() {

        override fun map(mapper: ToDoListResponseDomainToUiMapper<ResponseUi, EntityUi>): ResponseUi =
            mapper.map(errorType)
    }
}