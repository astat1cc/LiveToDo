package com.github.astat1cc.livetodo.feature_todolist.data.network.mappers

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.data.network.entities.ToDoDTO
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain

interface ToDoDTOtoDomainMapper : Abstract.ObjectMapper<ToDoDTO, ToDoDomain> {

    class Impl : ToDoDTOtoDomainMapper {

        override fun mapFrom(source: ToDoDTO): ToDoDomain = with(source) {
            ToDoDomain(title, checked)
        }
    }
}