package com.example.esiea3a.usercase


import com.example.esiea3a.Data.UserRepository
import com.example.esiea3a.Domain.GetUserUseCase
import com.example.esiea3a.Domain.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import junit.framework.TestCase.assertEquals


import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetUserUseCaseTest{
    private val userRepository: UserRepository = mockk()
    private val classUnderTest = GetUserUseCase(userRepository)

    @Test
    fun `invoke with invalid email`(){

        runBlocking {

            val email =  "a@a.c"
            val expectedUser = User("a@a.c")

            coEvery { userRepository.getUser(email) } returns expectedUser

            val result = classUnderTest.invoke(email)

            coVerify ( exactly = 1){ userRepository.getUser(email)}
            assertEquals(result, expectedUser)

        }
    }

}
