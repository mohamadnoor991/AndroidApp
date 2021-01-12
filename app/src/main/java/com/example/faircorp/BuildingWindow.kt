package com.example.faircorp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.faircorp.model.ApiServices
import com.example.faircorp.model.OnWindowSelectedListener
import com.example.faircorp.model.WindowAdapter
import com.example.faircorp.model.WindowService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BuildingWindow : BasicActivity(), OnWindowSelectedListener {
    val windowService = WindowService() // (1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building_window)

        val recyclerView = findViewById<RecyclerView>(R.id.list_windows) // (2)
        val adapter = WindowAdapter(this) // (3)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter

        runCatching { ApiServices().windowsApiService.findAll().execute() } // (1)
            .onSuccess { adapter.update(it.body() ?: emptyList()) }  // (2)
            .onFailure {
                Toast.makeText(this, "Error on windows loading $it", Toast.LENGTH_LONG)
                    .show()  // (3)
            }
//
//
//    }
fun onWindowSelected(id: Long) {
        val intent = Intent(this, WindowActivity::class.java).putExtra(WINDOW_NAME_PARAM, id)
        startActivity(intent)
    }
        /*******************************/

        lifecycleScope.launch(context = Dispatchers.IO)
        { // (1)
            runCatching { ApiServices().windowsApiService.findAll().execute() } // (2)
                .onSuccess {
                    withContext(context = Dispatchers.Main) { // (3)
                        adapter.update(it.body() ?: emptyList())
                    }
                }
                .onFailure {
                    withContext(context = Dispatchers.Main) { // (3)
                        Toast.makeText(
                            applicationContext,
                            "Error on windows loading $it",
                            Toast.LENGTH_LONG
                        ).show()
                    }
                }
        }

    }

    override fun onWindowSelected(id: Long) {//add new 2020 end
        val intent = Intent(this, WindowActivity::class.java).putExtra(WINDOW_NAME_PARAM, id)
        startActivity(intent)
    }
}
//}
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_building_window)
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menu_windows -> startActivity(
//                Intent(this, WindowsActivity::class.java)
//            )
//            R.id.menu_website -> startActivity(
//                Intent(Intent.ACTION_VIEW, Uri.parse("https://dev-mind.fr"))
//            )
//            R.id.menu_email -> startActivity(
//                Intent(Intent.ACTION_SENDTO, Uri.parse("mailto://guillaume@dev-mind.fr"))
//            )
//
//        }
//        return super.onContextItemSelected(item)
//    }
//}