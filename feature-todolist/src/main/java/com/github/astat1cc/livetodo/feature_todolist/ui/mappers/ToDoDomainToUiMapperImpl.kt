package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

class ToDoDomainToUiMapperImpl : ToDoDomainToUiMapper<ToDoUi> {

    override fun map(title: String, checked: Boolean): ToDoUi =
        ToDoUi(title, checked)
}