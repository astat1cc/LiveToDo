package com.github.astat1cc.livetodo.feature_todolist.domain

import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain

interface ToDoListRepository {

    suspend fun fetchToDoList(): List<ToDoDomain>
}