package com.github.astat1cc.livetodo.feature_todolist.ui.entities

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoListResponseUi
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseUiToScreenItemsMapper

sealed class ToDoListResponseUiImpl :
    ToDoListResponseUi,
    Abstract.Object<List<ToDoListScreenItem>, ToDoListResponseUiToScreenItemsMapper> {

    class Success(private val toDoList: List<ToDoUi>) : ToDoListResponseUiImpl() {

        override fun map(mapper: ToDoListResponseUiToScreenItemsMapper): List<ToDoListScreenItem> =
            mapper.map(toDoList)
    }

    class Fail(private val errorMessage: String) : ToDoListResponseUiImpl() {

        override fun map(mapper: ToDoListResponseUiToScreenItemsMapper): List<ToDoListScreenItem> =
            mapper.map(errorMessage)
    }

    object Loading : ToDoListResponseUiImpl() {

        override fun map(mapper: ToDoListResponseUiToScreenItemsMapper): List<ToDoListScreenItem> =
            mapper.map()
    }
}