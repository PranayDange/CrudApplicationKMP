package com.example.crudapplicationkmp.domain.repository

import com.example.crudapplicationkmp.domain.model.Student
import kotlinx.coroutines.flow.Flow
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import app.cash.sqldelight.coroutines.mapToOneOrNull
import com.example.crudapplicationkmp.database.StudentDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map

class StudentsRepositoryImpl(
    private val database: StudentDatabase
) : StudentsRepository {
    override fun getStudents(): Flow<List<Student>> {
        TODO("Not yet implemented")
    }

    override suspend fun addStudent(student: Student) {
        TODO("Not yet implemented")
    }

    override suspend fun updateStudent(student: Student) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteStudent(student: Student) {
        TODO("Not yet implemented")
    }
}