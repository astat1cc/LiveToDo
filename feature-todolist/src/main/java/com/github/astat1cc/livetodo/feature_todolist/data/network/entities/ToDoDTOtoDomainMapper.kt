package com.github.astat1cc.livetodo.feature_todolist.data.network.entities

import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain

interface ToDoDTOtoDomainMapper : Abstract.Mapper<ToDoDomain> {

    fun map(title: String, checked: Boolean): ToDoDomain

    class Impl:ToDoDTOtoDomainMapper {

        override fun map(title: String, checked: Boolean): ToDoDomain =
            ToDoDomain(title, checked)
    }
}