package com.github.astat1cc.livetodo.feature_todolist.domain.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel

interface ToDoDomainToUiMapper<EntityUi: ToDoUiModel> : Abstract.Mapper<EntityUi> {

    fun map(title: String, checked: Boolean): EntityUi
}