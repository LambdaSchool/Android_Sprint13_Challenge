package com.stepasha.makeup

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity<P : BasePresenter<BaseView>> : BaseView, AppCompatActivity() {

    protected lateinit var presenter: P
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter = instantiatePresenter()
    }
    protected abstract fun instantiatePresenter(): P

    override fun getContext(): Context {
        return this
    }

}
