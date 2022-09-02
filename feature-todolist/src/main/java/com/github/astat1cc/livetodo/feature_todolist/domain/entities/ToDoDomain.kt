package com.github.astat1cc.livetodo.feature_todolist.domain.entities

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.mappers.ToDoDomainToUiMapper

data class ToDoDomain<EntityUi : ToDoUiModel>(
    private val title: String,
    private val checked: Boolean
) : Abstract.Object<EntityUi, ToDoDomainToUiMapper<EntityUi>> {

    override fun map(mapper: ToDoDomainToUiMapper<EntityUi>): EntityUi = mapper.map(title, checked)
}