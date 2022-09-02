package com.github.astat1cc.livetodo.feature_todolist.data.network.entities

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain

data class ToDoDTO(
    private val title: String,
    private val checked: Boolean
) : Abstract.Object<ToDoDomain, ToDoDTOtoDomainMapper> {

    override fun map(mapper: ToDoDTOtoDomainMapper): ToDoDomain =
        mapper.map(title, checked)
}