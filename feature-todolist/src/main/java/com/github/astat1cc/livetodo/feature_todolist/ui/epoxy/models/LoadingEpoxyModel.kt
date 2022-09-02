package com.github.astat1cc.livetodo.feature_todolist.ui.epoxy.models

import com.github.astat1cc.livetodo.core.epoxy.ViewBindingKotlinModel
import com.github.astat1cc.livetodo.feature_todolist.R
import com.github.astat1cc.livetodo.feature_todolist.databinding.FullscreenProgressBinding

class LoadingEpoxyModel :
    ViewBindingKotlinModel<FullscreenProgressBinding>(R.layout.fullscreen_progress) {

    override fun FullscreenProgressBinding.bind() {}
}