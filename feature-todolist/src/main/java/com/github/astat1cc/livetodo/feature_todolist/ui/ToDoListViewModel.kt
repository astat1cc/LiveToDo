package com.github.astat1cc.livetodo.feature_todolist.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.feature_todolist.domain.ToDoListInteractor
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListResponseUi
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseDomainToUiMapper
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ToDoListResponseUiToScreenItemsMapper
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class ToDoListViewModel(
    private val interactor: ToDoListInteractor,
    private val domainToUiMapper: ToDoListResponseDomainToUiMapper,
    private val responseToScreenItemMapper: ToDoListResponseUiToScreenItemsMapper,
    private val resourceProvider: ResourceProvider,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {

//    private val _screenItems = MutableLiveData<List<ToDoListScreenItem>>()
//    val screenItems: LiveData<List<ToDoListScreenItem>> get() = _screenItems

    private val _screenItems: Flow<List<ToDoListScreenItem>> = flow {
        while (true) {
            delay(500L)
            val screenItems = mutableListOf<ToDoListScreenItem>()
            with(screenItems) {
                add(ToDoListScreenItem.Greeting("Dinar")) // todo don't hardcode
                addAll(responseToScreenItemMapper.mapFrom(toDoListResponse))
            }
        }
    } // todo maybe observe flow itself, and not livedata
    val screenItems = _screenItems.asLiveData(dispatcher) // todo make stateflow

    private var toDoListResponse: ToDoListResponseUi = ToDoListResponseUi.Loading

    init {
        fetchToDoList()
    }

    private fun fetchToDoList() {
        viewModelScope.launch(dispatcher) {
            val responseDomain = interactor.fetchToDoList()
            toDoListResponse = domainToUiMapper.mapFrom(responseDomain)
        }
    }
}