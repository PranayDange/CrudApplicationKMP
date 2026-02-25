package com.example.crudapplicationkmp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import com.example.crudapplicationkmp.di.databaseModule
import com.example.crudapplicationkmp.di.appModule

class CrudApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CrudApplication)
            modules(
                databaseModule,
                appModule
            )
        }
    }
}