package com.example.esiea3a.Presentation.Main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.esiea3a.Domain.User
import com.example.esiea3a.Domain.CreateUserUseCase
import com.example.esiea3a.Domain.GetUserUseCase
import kotlinx.coroutines.*

public class MainViewModel (
        private val createUserUseCase:CreateUserUseCase,
        private val getUserUseCase:GetUserUseCase
) : ViewModel(){
        val loginLiveData : MutableLiveData<LoginStatus> = MutableLiveData()

        fun onClickedLogin(emailUser: String, password: String) {
            viewModelScope.launch(Dispatchers.IO) {
                val user : User? = getUserUseCase.invoke(emailUser)
                val loginStatus =  if(user != null ){
                    LoginSuccess(user.email)
        }else{
            LoginError
        }

        withContext(Dispatchers.Main){
            loginLiveData.value = loginStatus
        }
     }

     }
    fun onClickedLoginAccount(user: User){
        viewModelScope.launch(Dispatchers.IO) {
        createUserUseCase.invoke(user)
        }
    }


}