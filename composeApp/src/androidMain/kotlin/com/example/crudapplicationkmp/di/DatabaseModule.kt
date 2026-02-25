package com.example.crudapplicationkmp.di

import com.example.crudapplicationkmp.data.database.DatabaseDriverFactory
import com.example.crudapplicationkmp.database.StudentDatabase
import org.koin.dsl.module

val databaseModule = module {

    single { DatabaseDriverFactory(get()) }

    single {
        StudentDatabase(
            driver = get<DatabaseDriverFactory>().createDriver()
        )
    }
}