package com.stepasha.makeupagain

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stepasha.makeupagain.adapter.MakeupRecyclerViewAdapter
import com.stepasha.makeupagain.retrofit.ApiCall
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class SearchActivity: AppCompatActivity() {

    private lateinit var disposable: Disposable

    @Inject
    lateinit var makeupService: ApiCall

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as App).appComponent.inject(this)

        recycler_view.setHasFixedSize(true)
        recycler_view.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)

        button_search.setOnClickListener {
            val searchedFor = edit_text_search.text.toString()

            if (searchedFor.isNotEmpty()) {

                progress_bar.visibility = View.VISIBLE

                disposable = makeupService.getMakeup(searchedFor)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({ brand ->
                        if (brand.isNotEmpty()) {
                            recycler_view.adapter = MakeupRecyclerViewAdapter(brand)
                        } else {
                            Toast.makeText(this, "Brand not found", Toast.LENGTH_SHORT).show()
                        }
                        progress_bar.visibility = View.INVISIBLE
                    }, { t ->
                        Log.i("Retrofit - ", "$t", t)
                    })
            } else {
                Toast.makeText(this, "Please enter a brand", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

    private fun showList() {

    }
}
