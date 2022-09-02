package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem

interface ToDoUiToScreenItemMapper : Abstract.Mapper<ToDoListScreenItem> {

    fun map(title: String, checked: Boolean): ToDoListScreenItem

    class Impl : ToDoUiToScreenItemMapper {

        override fun map(title: String, checked: Boolean): ToDoListScreenItem =
            ToDoListScreenItem.ToDo(title, checked)
    }
}