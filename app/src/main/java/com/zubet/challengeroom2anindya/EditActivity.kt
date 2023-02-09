package com.zubet.challengeroom2anindya

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zubet.challengeroom2anindya.room.Buku
import com.zubet.challengeroom2anindya.room.dbperpustakaan
import kotlinx.android.synthetic.main.activity_edit.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EditActivity : AppCompatActivity() {
    val db by lazy { dbperpustakaan(this) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit)
        simpandata()
    }
fun simpandata(){
    Btnsimpan.setOnClickListener {
        CoroutineScope(Dispatchers.IO).launch {
            db.tbBukuDAO().addBuku(
                Buku(ETid.text.toString().toInt(),ETkategori.text.toString(),ETjudul.text.toString(),ETpengarang.text.toString(),
                    ETpenerbit.text.toString(),ETjumlahbuku.text.toString().toInt())
            )
            finish()
        }
    }
}
}