package com.github.astat1cc.livetodo.feature_todolist.ui.entities

sealed class ToDoListScreenItem {

    class ToDo(
        val title: String,
        val checked: Boolean
    ) : ToDoListScreenItem()

    class Fail(val errorMessage: String) : ToDoListScreenItem()

    class Greeting(val name: String) : ToDoListScreenItem()

    object Loading : ToDoListScreenItem()
}