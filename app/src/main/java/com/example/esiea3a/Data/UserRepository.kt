package com.example.esiea3a.Data

import com.example.esiea3a.Data.Local.DataBaseDao
import com.example.esiea3a.Data.Local.Model.UserLocal
import com.example.esiea3a.Data.Local.Model.toData
import com.example.esiea3a.Data.Local.Model.toEntity
import com.example.esiea3a.Domain.User

class UserRepository (
    private val databaseDao: DataBaseDao
){

    suspend fun createUser(user : User){
        databaseDao.insert(user.toData())
    }

    fun getUser(email: String) : User? {
        val userLocal : UserLocal? = databaseDao.findByName(email)
        return userLocal?.toEntity()
    }
}