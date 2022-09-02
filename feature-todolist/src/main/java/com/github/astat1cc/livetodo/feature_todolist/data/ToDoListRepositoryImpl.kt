package com.github.astat1cc.livetodo.feature_todolist.data

import com.github.astat1cc.livetodo.feature_todolist.data.network.ToDoListNetworkDataSource
import com.github.astat1cc.livetodo.feature_todolist.data.network.mappers.ToDoDTOtoDomainMapper
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListRepository
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoDomain

class ToDoListRepositoryImpl(
    private val networkDataSource: ToDoListNetworkDataSource,
    private val networkMapper: ToDoDTOtoDomainMapper
) : ToDoListRepository {

    override suspend fun fetchToDoList(): List<ToDoDomain> =
        fetchFromNetwork()

    private suspend fun fetchFromNetwork() =
        networkDataSource.fetchToDoList().map { toDoDTO ->
            networkMapper.mapFrom(toDoDTO)
        }
}