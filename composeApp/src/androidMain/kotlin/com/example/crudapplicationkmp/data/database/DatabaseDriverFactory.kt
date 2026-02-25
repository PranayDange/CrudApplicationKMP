package com.example.crudapplicationkmp.data.database

import android.content.Context
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import com.example.crudapplicationkmp.database.StudentDatabase

class DatabaseDriverFactory(private val context: Context) {

    fun createDriver() =
        AndroidSqliteDriver(
            StudentDatabase.Schema,
            context,
            "student.db"
        )
}