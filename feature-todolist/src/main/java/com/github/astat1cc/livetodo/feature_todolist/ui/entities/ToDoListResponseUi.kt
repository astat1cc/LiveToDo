package com.github.astat1cc.livetodo.feature_todolist.ui.entities

sealed class ToDoListResponseUi  {

    class Success(val toDoList: List<ToDoUi>) : ToDoListResponseUi()

    class Fail(val errorMessage: String) : ToDoListResponseUi()

    object Loading : ToDoListResponseUi()
}