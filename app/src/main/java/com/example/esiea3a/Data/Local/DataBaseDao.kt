package com.example.esiea3a.Data.Local;

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.esiea3a.Data.Local.Model.UserLocal


@Dao
interface DataBaseDao {
    @Query("SELECT * FROM userlocal")
    fun getAll(): List<UserLocal>

    @Query("SELECT * FROM userlocal WHERE email LIKE :email LIMIT 1")
    fun findByName(email: String): UserLocal?

    @Insert
    fun insert(users: UserLocal)

    @Delete
    fun delete(user: UserLocal)
}