package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.ErrorType
import com.github.astat1cc.livetodo.core.R
import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoListResponseDomain
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListResponseUi

interface ToDoListResponseDomainToUiMapper :
    Abstract.ObjectMapper<ToDoListResponseDomain, ToDoListResponseUi> {

    class Impl(
        private val mapper: ToDoDomainToUiMapper,
        private val resourceProvider: ResourceProvider
    ) : ToDoListResponseDomainToUiMapper {

        override fun mapFrom(source: ToDoListResponseDomain): ToDoListResponseUi = when (source) {
            is ToDoListResponseDomain.Success -> mapSuccess(source.toDoList)
            is ToDoListResponseDomain.Fail -> mapError(source.errorType)
        }

        private fun mapSuccess(toDoList: List<ToDoDomain>): ToDoListResponseUi =
            ToDoListResponseUi.Success(
                toDoList.map { toDoDomain -> mapper.mapFrom(toDoDomain) }
            )

        private fun mapError(errorType: ErrorType): ToDoListResponseUi =
            ToDoListResponseUi.Fail(
                when (errorType) {
                    ErrorType.NO_CONNECTION -> resourceProvider.getString(R.string.no_connection_error_message)
                    ErrorType.SERVICE_UNAVAILABLE -> resourceProvider.getString(R.string.service_unavailable_error_message)
                    ErrorType.GENERIC_EXCEPTION -> resourceProvider.getString(R.string.something_went_wrong_error_message)
                }
            )
    }
}