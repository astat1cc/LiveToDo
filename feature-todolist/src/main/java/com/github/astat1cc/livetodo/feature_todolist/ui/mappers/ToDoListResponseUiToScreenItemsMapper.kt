package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

interface ToDoListResponseUiToScreenItemsMapper : Abstract.Mapper<List<ToDoListScreenItem>> {

    fun map(toDoList: List<ToDoUi>): List<ToDoListScreenItem>

    fun map(errorMessage: String): List<ToDoListScreenItem>

    fun map(): List<ToDoListScreenItem>

    class Impl(
        private val mapper: ToDoUiToScreenItemMapper
    ) : ToDoListResponseUiToScreenItemsMapper {

        override fun map(toDoList: List<ToDoUi>): List<ToDoListScreenItem> =
            toDoList.map { toDoUi ->
                toDoUi.map(mapper)
            }

        override fun map(errorMessage: String): List<ToDoListScreenItem> =
            listOf(ToDoListScreenItem.Fail(errorMessage))

        override fun map(): List<ToDoListScreenItem> =
            listOf(ToDoListScreenItem.Loading)
    }
}