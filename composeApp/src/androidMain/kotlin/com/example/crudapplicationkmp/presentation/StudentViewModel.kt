package com.example.crudapplicationkmp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.crudapplicationkmp.domain.model.Student
import com.example.crudapplicationkmp.domain.repository.StudentsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StudentViewModel(
    private val repository: StudentsRepository
) : ViewModel() {


    private val _state = MutableStateFlow(StudentState())
    val state: StateFlow<StudentState> = _state.asStateFlow()

    init {
        observeStudents()
    }

    private fun observeStudents() {
        viewModelScope.launch {
            repository.getStudents().collect { list ->
                _state.update { it.copy(students = list) }
            }
        }
    }

    fun onIntent(intent: StudentIntent) {
        when (intent) {

            is StudentIntent.NameChanged ->
                _state.update { it.copy(name = intent.value) }

            is StudentIntent.AgeChanged ->
                _state.update { it.copy(age = intent.value) }

            is StudentIntent.ClassChanged ->
                _state.update { it.copy(studentClass = intent.value) }

            is StudentIntent.TownChanged ->
                _state.update { it.copy(town = intent.value) }

            StudentIntent.SaveStudent -> saveStudent()

            is StudentIntent.DeleteStudent ->
                deleteStudent(intent.student)
        }
    }

    private fun saveStudent() {
        viewModelScope.launch {
            val current = _state.value

            if (current.name.isBlank() || current.age.isBlank()) return@launch

            repository.addStudent(
                Student(
                    id = 0,
                    name = current.name,
                    age = current.age.toInt(),
                    studentClass = current.studentClass,
                    town = current.town
                )
            )

            _state.update {
                it.copy(
                    name = "",
                    age = "",
                    studentClass = "",
                    town = ""
                )
            }
        }
    }

    private fun deleteStudent(student: Student) {
        viewModelScope.launch {
            repository.deleteStudent(student)
        }
    }

}