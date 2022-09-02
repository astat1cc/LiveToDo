package com.github.astat1cc.livetodo.feature_todolist.domain.entities

import com.github.astat1cc.livetodo.core.ErrorType

sealed class ToDoListResponseDomain {

    class Success(val toDoList: List<ToDoDomain>) : ToDoListResponseDomain()

    class Fail(val errorType: ErrorType) : ToDoListResponseDomain()
}