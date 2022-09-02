package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListResponseUi
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

interface ToDoListResponseUiToScreenItemsMapper :
    Abstract.ObjectMapper<ToDoListResponseUi, List<ToDoListScreenItem>> {

    class Impl(
        private val mapper: ToDoUiToScreenItemMapper
    ) : ToDoListResponseUiToScreenItemsMapper {

        override fun mapFrom(source: ToDoListResponseUi): List<ToDoListScreenItem> = when (source) {
            is ToDoListResponseUi.Success -> mapSuccess(source.toDoList)
            is ToDoListResponseUi.Fail -> mapError(source.errorMessage)
            is ToDoListResponseUi.Loading -> mapLoading()
        }

        private fun mapSuccess(toDoList: List<ToDoUi>): List<ToDoListScreenItem> =
            toDoList.map { toDoUi ->
                mapper.mapFrom(toDoUi)
            }

        private fun mapError(errorMessage: String): List<ToDoListScreenItem> =
            listOf(ToDoListScreenItem.Fail(errorMessage))

        private fun mapLoading(): List<ToDoListScreenItem> =
            listOf(ToDoListScreenItem.Loading)
    }
}