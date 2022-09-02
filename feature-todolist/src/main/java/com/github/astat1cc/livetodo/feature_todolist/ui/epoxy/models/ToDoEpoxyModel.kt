package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models

import com.github.astat1cc.livetodo.core.epoxy.ViewBindingKotlinModel
import com.github.astat1cc.livetodo.feature_todolist.R
import com.github.astat1cc.livetodo.feature_todolist.databinding.ItemToDoBinding

class ToDoEpoxyModel(
    private val title: String,
    private val checked: Boolean // todo implement checking in bind()
) : ViewBindingKotlinModel<ItemToDoBinding>(R.layout.item_to_do) {

    override fun ItemToDoBinding.bind() {
        titleTV.text = title
    }
}