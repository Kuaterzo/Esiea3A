package com.example.esiea3a.Domain

import com.example.esiea3a.Data.UserRepository

class GetUserUseCase ( private val userRepository: UserRepository){
    suspend fun invoke (email: String) : User? {
        return  userRepository.getUser(email)
    }

}