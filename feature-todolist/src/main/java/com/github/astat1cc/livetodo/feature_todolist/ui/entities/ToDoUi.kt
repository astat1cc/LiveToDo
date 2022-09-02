package com.github.astat1cc.livetodo.feature_todolist.ui.entities

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoUiToScreenItemMapper

class ToDoUi(
    private val title: String,
    private val checked: Boolean
) : ToDoUiModel, Abstract.Object<ToDoListScreenItem, ToDoUiToScreenItemMapper> {

    override fun map(mapper: ToDoUiToScreenItemMapper): ToDoListScreenItem =
        mapper.map(title, checked)
}
