package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy

import com.airbnb.epoxy.EpoxyController
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ScreenItemToEpoxyModelMapper

class ToDoListEpoxyController(
    private val mapper: ScreenItemToEpoxyModelMapper
) : EpoxyController() {

    private var toDoListScreenItems: List<ToDoListScreenItem> = emptyList()

    fun setData(newList: List<ToDoListScreenItem>) {
        toDoListScreenItems = newList
        buildModels()
    }

    override fun buildModels() {
        toDoListScreenItems.forEachIndexed { index, item ->
            mapper.mapFrom(item).id(index).addTo(this)
        }
    }
}