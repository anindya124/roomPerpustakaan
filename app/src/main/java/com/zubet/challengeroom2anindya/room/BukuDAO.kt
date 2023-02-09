package com.zubet.challengeroom2anindya.room

import androidx.room.*

@Dao
interface BukuDAO {
    @Insert
    fun addBuku (buk:Buku)
    @Update
    fun updateBuku (buk: Buku)
    @Delete
    fun deleteBuku (buk: Buku)
    @Query ("SELECT * FROM Buku")
    fun tampilsemua(): List<Buku>
}