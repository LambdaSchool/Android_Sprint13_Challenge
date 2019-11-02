package com.versilis.sprintproject.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.versilis.sprintproject.MainApplication
import com.versilis.sprintproject.R
import com.versilis.sprintproject.data.local.model.Makeup
import com.versilis.sprintproject.data.remote.MakeupApiProvider
import com.versilis.sprintproject.data.remote.MakeupApiService
import com.versilis.sprintproject.di.DaggerMakeupNetworkComponent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_makeup_list.*
import javax.inject.Inject

class MakeupListActivity : AppCompatActivity() {

    private var disposable: Disposable? = null
    @Inject
    lateinit var makeupApiService: MakeupApiService
    val makeupList = listOf<Makeup>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_makeup_list)

        (application as MainApplication).networkComponent.inject(this)
        val adapter = MakeupRecyclerAdapter(makeupList)
        initRV( adapter)
        bttn_submit_query.setOnClickListener {
            if (!et_search.text.isNullOrEmpty()) {
               val brandNameQueryText = et_search.text.toString()
               getMakeupProductsByBrandName(brandNameQueryText, adapter, makeupApiService)
            }
        }

    }

    override fun onPause() {
        disposable?.dispose()
        super.onPause()
    }
    private fun getMakeupProductsByBrandName(brandName: String, adapter: MakeupRecyclerAdapter, service: MakeupApiService) {
        disposable = service.getProductsByBrand(brandName)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result ->
                    val newList = result
                    adapter.update(newList)
                },
                { error -> error.printStackTrace() }
            )
    }
    private fun initRV(rvAdapter: MakeupRecyclerAdapter) {
        rv_makeup_list.adapter = rvAdapter
        rv_makeup_list.setHasFixedSize(true)
        rv_makeup_list.isNestedScrollingEnabled = false
        rv_makeup_list.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
    }
}
