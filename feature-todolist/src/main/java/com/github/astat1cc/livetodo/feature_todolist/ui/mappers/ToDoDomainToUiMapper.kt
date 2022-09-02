package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoUi

interface ToDoDomainToUiMapper : Abstract.ObjectMapper<ToDoDomain, ToDoUi> {

    class Impl : ToDoDomainToUiMapper {

        override fun mapFrom(source: ToDoDomain): ToDoUi = with(source) {
            ToDoUi(title, checked)
        }
    }
}