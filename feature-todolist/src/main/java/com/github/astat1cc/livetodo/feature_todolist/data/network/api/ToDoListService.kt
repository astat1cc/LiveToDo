package com.github.astat1cc.livetodo.feature_todolist.data.network.api

import com.github.astat1cc.livetodo.feature_todolist.data.network.entities.ToDoDTO

interface ToDoListService {

    //todo implement firebase service
    suspend fun fetchToDoList(): List<ToDoDTO>
}