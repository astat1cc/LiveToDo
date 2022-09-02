package com.github.astat1cc.livetodo.feature_todolist.domain.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.core.ErrorType
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoListResponseUi
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel

interface ToDoListResponseDomainToUiMapper<ResponseUi : ToDoListResponseUi, EntityUi : ToDoUiModel> :
    Abstract.Mapper<ResponseUi> {

    fun map(toDoList: List<ToDoDomain<EntityUi>>): ResponseUi

    fun map(errorType: ErrorType): ResponseUi
}