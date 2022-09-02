package com.github.astat1cc.livetodo.feature_todolist.ui.mappers

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.github.astat1cc.livetodo.core.ResourceProvider
import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.R
import com.github.astat1cc.livetodo.feature_todolist.ui.entities.ToDoListScreenItem
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.ErrorEpoxyModel
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.GreetingEpoxyModel
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.LoadingEpoxyModel
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.ToDoEpoxyModel

interface ScreenItemToEpoxyModelMapper :
    Abstract.ObjectMapper<ToDoListScreenItem, EpoxyModel<View>> {

    fun mapToDo(title: String, checked: Boolean): ToDoEpoxyModel

    fun mapError(message: String): ErrorEpoxyModel

    fun mapGreeting(name: String): GreetingEpoxyModel

    fun mapLoading(): LoadingEpoxyModel

    class Impl(
        private val resourceProvider: ResourceProvider
    ) : ScreenItemToEpoxyModelMapper {

        override fun mapFrom(source: ToDoListScreenItem): EpoxyModel<View> = when (source) {
            is ToDoListScreenItem.ToDo -> mapToDo(title = source.title, checked = source.checked)
            is ToDoListScreenItem.Fail -> mapError(source.errorMessage)
            is ToDoListScreenItem.Greeting -> mapGreeting(source.name)
            is ToDoListScreenItem.Loading -> mapLoading()
        }

        override fun mapToDo(title: String, checked: Boolean): ToDoEpoxyModel =
            ToDoEpoxyModel(title, checked)

        override fun mapError(message: String): ErrorEpoxyModel = ErrorEpoxyModel(message)

        override fun mapGreeting(name: String): GreetingEpoxyModel = GreetingEpoxyModel(
            resourceProvider.getString(
                R.string.greeting,
                name.replaceFirstChar {
                    it.uppercaseChar()
                })
        )

        override fun mapLoading(): LoadingEpoxyModel =
            LoadingEpoxyModel()
    }
}