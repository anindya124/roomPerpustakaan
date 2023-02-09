package com.zubet.challengeroom2anindya

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.zubet.challengeroom2anindya.room.dbperpustakaan
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    val db by lazy { dbperpustakaan(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        halEdit()
    }

    override fun onStart() {
        super.onStart()
        CoroutineScope(Dispatchers.IO).launch {
            val book = db.tbBukuDAO().tampilsemua()
            Log.d("MainActivity","dbResponse: $book")
            withContext(Dispatchers.Main){
            }
        }
    }
    private fun halEdit(){
        BtnInput.setOnClickListener {
        startActivity(Intent(this,EditActivity::class.java))
        }
    }
}