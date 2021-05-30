package com.example.esiea3a.Data.Local;

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.esiea3a.Data.Local.Model.UserLocal


@Database(entities = arrayOf(
    UserLocal::class
),  version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DataBaseDao
}
