package com.github.astat1cc.livetodo.feature_todolist.ui.entities

import android.view.View
import com.airbnb.epoxy.EpoxyModel
import com.github.astat1cc.livetodo.core.abstracts.Abstract
import com.github.astat1cc.livetodo.feature_todolist.domain.entities.ToDoUiModel
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.ErrorEpoxyModel
import com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models.ToDoEpoxyModel
import com.github.astat1cc.livetodo.feature_todolist.ui.mappers.ScreenItemToEpoxyModelMapper

sealed class ToDoListScreenItem :
    Abstract.Object<EpoxyModel<View>, ScreenItemToEpoxyModelMapper> {

    class ToDo(
        private val title: String,
        private val checked: Boolean
    ) : ToDoListScreenItem() {

        override fun map(mapper: ScreenItemToEpoxyModelMapper): ToDoEpoxyModel =
            mapper.mapToDo(title, checked)
    }

    class Fail(private val errorMessage: String) : ToDoListScreenItem() {

        override fun map(mapper: ScreenItemToEpoxyModelMapper): ErrorEpoxyModel =
            mapper.mapError(errorMessage)
    }

    class Greeting(private val name: String) : ToDoListScreenItem() {

        override fun map(mapper: ScreenItemToEpoxyModelMapper): EpoxyModel<View> =
            mapper.mapGreeting(name)
    }

    object Loading : ToDoListScreenItem() {

        override fun map(mapper: ScreenItemToEpoxyModelMapper): EpoxyModel<View> =
            mapper.mapLoading()
    }
}