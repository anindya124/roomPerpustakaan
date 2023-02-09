package com.zubet.challengeroom2anindya.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Buku (
    @PrimaryKey
    val idBuku : Int,
    val kategori : String,
    val judul : String,
    val pengarang : String,
    val penerbit : String,
    val jumlahBuku : Int

    )