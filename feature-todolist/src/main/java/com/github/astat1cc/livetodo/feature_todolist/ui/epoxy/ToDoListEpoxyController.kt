package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy

import com.airbnb.epoxy.EpoxyController
import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ScreenItemToEpoxyModelMapper

class ToDoListEpoxyController(
    private val mapper: ScreenItemToEpoxyModelMapper
) : EpoxyController(), Abstract.Mapper<Unit> {

    private var toDoListScreenItems: List<ToDoListScreenItem> = emptyList()

    fun setData(newList: List<ToDoListScreenItem>) {
        toDoListScreenItems = newList
        buildModels()
    }

    override fun buildModels() {
        toDoListScreenItems.forEachIndexed { index, item ->
            item.map(mapper).id(index).addTo(this)
        }
    }
}