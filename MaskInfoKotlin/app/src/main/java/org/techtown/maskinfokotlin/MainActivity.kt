package org.techtown.maskinfokotlin

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import org.techtown.maskinfokotlin.model.Store

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val storeAdapter = StoreAdapter()

        recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity,
                RecyclerView.VERTICAL,
                false)
            adapter = storeAdapter
        }

        viewModel.apply {
            itemLiveData.observe(this@MainActivity, Observer {
                storeAdapter.updateItems(it)
            })
            loadingLiveData.observe(this@MainActivity, Observer { isLoading ->
                progressBar.visibility = if(isLoading) View.VISIBLE else View.GONE
            })
        }
    }
}