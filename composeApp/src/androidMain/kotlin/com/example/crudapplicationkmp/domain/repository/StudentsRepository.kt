package com.example.crudapplicationkmp.domain.repository

import com.example.crudapplicationkmp.domain.model.Student
import kotlinx.coroutines.flow.Flow

interface StudentsRepository {

    fun getStudents(): Flow<List<Student>>

    suspend fun addStudent(student: Student)

    suspend fun updateStudent(student: Student)

    suspend fun deleteStudent(student: Student)
}

//created StudentsRepository,StudentsRepositoryImpl and Di