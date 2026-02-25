package com.example.crudapplicationkmp.di

import com.example.crudapplicationkmp.domain.repository.StudentsRepository
import com.example.crudapplicationkmp.data.repository.StudentsRepositoryImpl
import com.example.crudapplicationkmp.presentation.StudentViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel


val appModule = module {

    single<StudentsRepository> {
        StudentsRepositoryImpl(get())
    }
    viewModel {
        StudentViewModel(get())
    }
}