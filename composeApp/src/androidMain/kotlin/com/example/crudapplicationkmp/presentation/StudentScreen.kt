package com.example.crudapplicationkmp.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.androidx.compose.koinViewModel


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.androidx.compose.koinViewModel
@Composable
fun StudentScreen(
    viewModel: StudentViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = if (state.editingStudentId == null) "Add Student"
            else "Update Student",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(Modifier.height(12.dp))

        OutlinedTextField(
            value = state.name,
            onValueChange = { viewModel.onIntent(StudentIntent.NameChanged(it)) },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(8.dp))

        Row {
            OutlinedTextField(
                value = state.age,
                onValueChange = { viewModel.onIntent(StudentIntent.AgeChanged(it)) },
                label = { Text("Age") },
                modifier = Modifier.weight(1f)
            )

            Spacer(Modifier.width(8.dp))

            OutlinedTextField(
                value = state.studentClass,
                onValueChange = { viewModel.onIntent(StudentIntent.ClassChanged(it)) },
                label = { Text("Class") },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(Modifier.height(8.dp))

        OutlinedTextField(
            value = state.town,
            onValueChange = { viewModel.onIntent(StudentIntent.TownChanged(it)) },
            label = { Text("Town") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(12.dp))

        Button(
            onClick = { viewModel.onIntent(StudentIntent.SaveStudent) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                if (state.editingStudentId == null)
                    "Save Student"
                else
                    "Update Student"
            )
        }

        Spacer(Modifier.height(20.dp))

        Divider()

        Spacer(Modifier.height(12.dp))

        LazyColumn(
            modifier = Modifier.weight(1f)
        ) {
            items(state.students) { student ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 6.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(12.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                student.name,
                                style = MaterialTheme.typography.titleMedium
                            )
                            Text("Age: ${student.age}")
                            Text("Class: ${student.studentClass}")
                            Text("Town: ${student.town}")
                        }

                        Column {
                            TextButton(
                                onClick = {
                                    viewModel.onIntent(
                                        StudentIntent.EditStudent(student)
                                    )
                                }
                            ) {
                                Text("Edit")
                            }

                            TextButton(
                                onClick = {
                                    viewModel.onIntent(
                                        StudentIntent.DeleteStudent(student)
                                    )
                                }
                            ) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}