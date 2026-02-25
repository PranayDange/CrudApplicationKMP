package com.example.crudapplicationkmp.presentation

import com.example.crudapplicationkmp.domain.model.Student

sealed class StudentIntent {
    data class NameChanged(val value: String) : StudentIntent()
    data class AgeChanged(val value: String) : StudentIntent()
    data class ClassChanged(val value: String) : StudentIntent()
    data class TownChanged(val value: String) : StudentIntent()

    object SaveStudent : StudentIntent()
    data class EditStudent(val student: Student) : StudentIntent()

    data class DeleteStudent(val student: Student) : StudentIntent()
}

data class StudentState(
    val name: String = "",
    val age: String = "",
    val studentClass: String = "",
    val town: String = "",
    val students: List<Student> = emptyList(),
    val editingStudentId: Long? = null
)