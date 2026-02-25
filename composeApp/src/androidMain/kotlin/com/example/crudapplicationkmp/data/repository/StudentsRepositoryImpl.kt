package com.example.crudapplicationkmp.data.repository

import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList
import com.example.crudapplicationkmp.database.StudentDatabase
import com.example.crudapplicationkmp.domain.model.Student
import com.example.crudapplicationkmp.domain.repository.StudentsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class StudentsRepositoryImpl(
    private val database: StudentDatabase
) : StudentsRepository {
    private val queries = database.studentQueries


    override fun getStudents(): Flow<List<Student>> {
        return queries
            .selectAll()
            .asFlow()
            .mapToList(Dispatchers.IO)
            .map { list ->
                list.map {
                    Student(
                        id = it.id,
                        name = it.name,
                        age = it.age.toInt(),
                        studentClass = it.studentClass,
                        town = it.town
                    )
                }
            }
    }

    override suspend fun addStudent(student: Student) {
        queries.insertStudent(
            name = student.name,
            age = student.age.toLong(),
            studentClass = student.studentClass,
            town = student.town
        )
    }

    override suspend fun updateStudent(student: Student) {
        queries.updateStudent(
            name = student.name,
            age = student.age.toLong(),
            studentClass = student.studentClass,
            town = student.town,
            id = student.id
        )
    }

    override suspend fun deleteStudent(student: Student) {
        queries.deleteStudent(student.id)
    }
}