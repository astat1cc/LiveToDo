package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

interface ToDoUiToScreenItemMapper : Abstract.ObjectMapper<ToDoUi, ToDoListScreenItem> {

    class Impl : ToDoUiToScreenItemMapper {

        override fun mapFrom(source: ToDoUi): ToDoListScreenItem = with(source) {
            ToDoListScreenItem.ToDo(title, checked)
        }
    }
}