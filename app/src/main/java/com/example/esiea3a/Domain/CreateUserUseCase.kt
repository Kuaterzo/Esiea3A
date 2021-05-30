package com.example.esiea3a.Domain

import com.example.esiea3a.Data.UserRepository

class CreateUserUseCase( private val userRepository: UserRepository) {
    suspend fun invoke(user : User){
        userRepository.createUser(user)

    }

}