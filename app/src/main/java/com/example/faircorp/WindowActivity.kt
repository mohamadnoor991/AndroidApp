package com.example.faircorp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faircorp.model.WindowAdapter
import com.example.faircorp.model.WindowService


//class WindowsActivity : BasicActivity() {
//
//    val windowService = WindowService() // (1)
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_windows)
//
//        val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
//        val adapter = WindowAdapter() // (3)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
//        recyclerView.setHasFixedSize(true)
//        recyclerView.adapter = adapter
//
//        adapter.update(windowService.findAll()) // (4)
//    }
//}



class WindowActivity : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_window)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val param = intent.getStringExtra(WINDOW_NAME_PARAM)
        val windowName = findViewById<TextView>(R.id.txt_window_name)
        windowName.text = param




        }

    }









