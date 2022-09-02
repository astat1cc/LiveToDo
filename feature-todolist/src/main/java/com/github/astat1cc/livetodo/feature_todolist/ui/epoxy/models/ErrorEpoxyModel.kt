package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models

import com.github.astat1cc.livetodo.core.epoxy.ViewBindingKotlinModel
import com.github.astat1cc.livetodo.feature_todolist.R
import com.github.astat1cc.livetodo.feature_todolist.databinding.ItemErrorBinding

class ErrorEpoxyModel(
    private val errorMessage: String
) : ViewBindingKotlinModel<ItemErrorBinding>(R.layout.item_error) {

    override fun ItemErrorBinding.bind() {
        errorTV.text = errorMessage
    }
}