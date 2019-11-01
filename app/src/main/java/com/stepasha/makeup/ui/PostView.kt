package com.stepasha.makeup.ui

import androidx.annotation.StringRes
import com.stepasha.makeup.BaseView
import com.stepasha.makeup.model.MakeupItem

interface PostView : BaseView{

    fun updateMakeup(makeup: List<MakeupItem>)

    fun showError(error: String)

    fun showError(@StringRes errorResId: Int){
        this.showError(getContext().getString(errorResId))
    }

    fun showLoading()

    fun hideLoading()
}