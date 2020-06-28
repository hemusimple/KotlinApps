package com.innoviti.kotlinapps.activitity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.innoviti.kotlinapps.R
import com.innoviti.kotlinapps.adapters.ListAdapter
import com.innoviti.kotlinapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var listAdapter:ListAdapter
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        init()
    }

    private fun  init(){
        listAdapter = ListAdapter(this)
        activityMainBinding.list.adapter = listAdapter
        activityMainBinding.list.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        activityMainBinding.list.setHasFixedSize(true)
        listAdapter.setData(prepareTemp())
    }

    private  fun prepareTemp():List<String>{
        val temp =ArrayList<String>()
        temp.add("Apple")
        temp.add("Banana")
        temp.add("Mango")
        temp.add("Pomegranate")
        return  temp
    }

}