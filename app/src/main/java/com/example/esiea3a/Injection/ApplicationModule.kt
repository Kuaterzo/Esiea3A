package com.example.esiea3a.Injection

import android.content.Context
import androidx.room.Room
import com.example.esiea3a.Data.Local.AppDatabase
import com.example.esiea3a.Data.Local.DataBaseDao
import com.example.esiea3a.Data.UserRepository
import com.example.esiea3a.Domain.CreateUserUseCase
import com.example.esiea3a.Domain.GetUserUseCase
import com.example.esiea3a.Presentation.Main.MainViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module


val presentationModule = module {
    factory { MainViewModel(get(), get()) }

}
val domainModule : Module = module {
    factory { CreateUserUseCase(get()) }
    factory { GetUserUseCase(get()) }
}
val dataModule : Module = module {
    single { UserRepository(get()) }
    single {createDataBase(androidContext())}
}

fun createDataBase(context: Context): DataBaseDao {
    val appDatabase : AppDatabase = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "database-name"
    ).build()
    return appDatabase.databaseDao()
}