package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models

import com.github.astat1cc.livetodo.core.epoxy.ViewBindingKotlinModel
import com.github.astat1cc.livetodo.feature_todolist.R
import com.github.astat1cc.livetodo.feature_todolist.databinding.ItemGreetingBinding

class GreetingEpoxyModel(
    private val greeting: String
) : ViewBindingKotlinModel<ItemGreetingBinding>(R.layout.item_greeting) {

    override fun ItemGreetingBinding.bind() {
        greetingTV.text = greeting
    }
}