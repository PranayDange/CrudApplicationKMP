package com.example.crudapplicationkmp.di

import com.example.crudapplicationkmp.domain.repository.StudentsRepository
import com.example.crudapplicationkmp.domain.repository.StudentsRepositoryImpl
import org.koin.dsl.module

val appModule = module {

    single<StudentsRepository> {
        StudentsRepositoryImpl(get())
    }
}