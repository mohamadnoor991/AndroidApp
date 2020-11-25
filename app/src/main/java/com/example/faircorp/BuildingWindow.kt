package com.example.faircorp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem

class BuildingWindow : BasicActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_building_window)
    }

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
}