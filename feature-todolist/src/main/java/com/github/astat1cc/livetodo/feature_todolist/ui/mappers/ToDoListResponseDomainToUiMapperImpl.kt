package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.ErrorType
import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.core.R
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoListResponseUi
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoListResponseDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListResponseUiImpl
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

class ToDoListResponseDomainToUiMapperImpl(
    private val mapper: ToDoDomainToUiMapperImpl,
    private val resourceProvider: ResourceProvider
) : ToDoListResponseDomainToUiMapper<ToDoListResponseUiImpl, ToDoUi> {

    override fun map(toDoList: List<ToDoDomain<ToDoUi>>): ToDoListResponseUiImpl =
        ToDoListResponseUiImpl.Success(
            toDoList.map { toDoDomain -> toDoDomain.map(mapper) }
        )

    override fun map(errorType: ErrorType): ToDoListResponseUiImpl =
        ToDoListResponseUiImpl.Fail(
            when (errorType) {
                ErrorType.NO_CONNECTION -> resourceProvider.getString(R.string.no_connection_error_message)
                ErrorType.SERVICE_UNAVAILABLE -> resourceProvider.getString(R.string.service_unavailable_error_message)
                ErrorType.GENERIC_EXCEPTION -> resourceProvider.getString(R.string.something_went_wrong_error_message)
            }
        )
}