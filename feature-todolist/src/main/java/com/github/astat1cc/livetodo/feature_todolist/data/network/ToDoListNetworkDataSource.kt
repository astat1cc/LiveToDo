package com.github.astat1cc.livetodo.feature_todolist.data.network

import com.github.astat1cc.livetodo.feature_todolist.data.network.api.ToDoListService
import com.github.astat1cc.livetodo.feature_todolist.data.network.entities.ToDoDTO

interface ToDoListNetworkDataSource {

    suspend fun fetchToDoList(): List<ToDoDTO>

    class Impl(private val service: ToDoListService) : ToDoListNetworkDataSource {

        override suspend fun fetchToDoList(): List<ToDoDTO> = service.fetchToDoList()
    }
}