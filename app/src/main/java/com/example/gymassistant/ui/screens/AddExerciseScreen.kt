package com.example.gymassistant.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.gymassistant.constants.MuscleGroup
import com.example.gymassistant.ui.builders.MuscleTreeProvider
import com.example.gymassistant.ui.models.MuscleWorked

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddExerciseScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var name by remember { mutableStateOf("") }

    // First dropdown: Category (top-level MuscleGroup)
    var selectedCategory by remember { mutableStateOf<MuscleGroup?>(null) }
    var categoryExpanded by remember { mutableStateOf(false) }

    // Second dropdown: Group (enum under the selected category)
    var selectedGroup by remember { mutableStateOf<Enum<*>?>(null) }
    var groupExpanded by remember { mutableStateOf(false) }

    // Third dropdown: Subgroup (enum under the selected group)
    var selectedSubgroup by remember { mutableStateOf<Enum<*>?>(null) }
    var subgroupExpanded by remember { mutableStateOf(false) }

    val muscleTree = remember { MuscleTreeProvider.muscleTree }
    val categories = muscleTree.map { it.value as MuscleGroup }

    val groups: List<Enum<*>> = selectedCategory?.let { cat ->
        muscleTree.firstOrNull { it.value == cat }?.subgroups?.map { it.value } ?: emptyList()
    } ?: emptyList()

    val subgroups: List<Enum<*>> = selectedGroup?.let { g ->
        val categoryNode = muscleTree.firstOrNull { it.value == selectedCategory }
        val groupNode = categoryNode?.subgroups?.firstOrNull { it.value == g }
        groupNode?.subgroups?.map { it.value } ?: emptyList()
    } ?: emptyList()

    // Multiple selected groups/subgroups worked for this exercise
    var selectedWorked by remember { mutableStateOf<List<MuscleWorked>>(emptyList()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(text = "Add Exercise")
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Exercise name") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Category row (top-level MuscleGroup)
        Row(modifier = Modifier.fillMaxWidth()) {
            ExposedDropdownMenuBox(
                expanded = categoryExpanded,
                onExpandedChange = { categoryExpanded = !categoryExpanded },
                modifier = Modifier
                    .weight(2f)
            ) {
                TextField(
                    readOnly = true,
                    value = selectedCategory?.name ?: "Category",
                    onValueChange = {},
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = categoryExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = categoryExpanded,
                    onDismissRequest = { categoryExpanded = false }
                ) {
                    categories.forEach { cat ->
                        DropdownMenuItem(
                            text = { Text(cat.name) },
                            onClick = {
                                selectedCategory = cat
                                selectedGroup = null
                                selectedSubgroup = null
                                categoryExpanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Group + Subgroup row
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            // Group dropdown (depends on selected category)
            ExposedDropdownMenuBox(
                expanded = groupExpanded,
                onExpandedChange = {
                    if (selectedCategory != null) groupExpanded = !groupExpanded
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                TextField(
                    readOnly = true,
                    value = selectedGroup?.name ?: "Group",
                    onValueChange = {},
                    enabled = selectedCategory != null,
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = groupExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = groupExpanded,
                    onDismissRequest = { groupExpanded = false }
                ) {
                    groups.forEach { g ->
                        DropdownMenuItem(
                            text = { Text(g.name) },
                            onClick = {
                                selectedGroup = g
                                selectedSubgroup = null
                                groupExpanded = false
                            }
                        )
                    }
                }
            }

            // Subgroup dropdown (depends on selected group)
            ExposedDropdownMenuBox(
                expanded = subgroupExpanded,
                onExpandedChange = {
                    if (selectedGroup != null && subgroups.isNotEmpty()) {
                        subgroupExpanded = !subgroupExpanded
                    }
                },
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                TextField(
                    readOnly = true,
                    value = selectedSubgroup?.name ?: "Subgroup",
                    onValueChange = {},
                    enabled = selectedGroup != null && subgroups.isNotEmpty(),
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = subgroupExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = subgroupExpanded,
                    onDismissRequest = { subgroupExpanded = false }
                ) {
                    subgroups.forEach { subgroup ->
                        DropdownMenuItem(
                            text = { Text(subgroup.name) },
                            onClick = {
                                selectedSubgroup = subgroup
                                subgroupExpanded = false
                            }
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Add current selection to the worked-groups list
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {
                    selectedCategory?.let { cat ->
                        val subgroupForPersist = selectedSubgroup ?: selectedGroup
                        val entry = MuscleWorked(group = cat, subgroup = subgroupForPersist)
                        if (entry !in selectedWorked) {
                            selectedWorked = selectedWorked + entry
                        }
                        // reset lower selections
                        selectedGroup = null
                        selectedSubgroup = null
                    }
                },
                enabled = selectedCategory != null && selectedGroup != null
            ) {
                Text("Add group")
            }
        }

        Spacer(modifier = Modifier.height(12.dp))

        // Show selected worked groups
        if (selectedWorked.isNotEmpty()) {
            Column(modifier = Modifier.fillMaxWidth()) {
                selectedWorked.forEachIndexed { index, worked ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        val label = buildString {
                            append(worked.group.name)
                            worked.subgroup?.let { append(" / ${it.name}") }
                        }
                        Text(text = label, modifier = Modifier.weight(1f))
                        Button(onClick = { selectedWorked = selectedWorked.filterIndexed { i, _ -> i != index } }) {
                            Text("Remove")
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.height(12.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Persist selectedWorked list
                val groupsWorked = selectedWorked
                // val exercise = Exercise(name = name, groupsWorked = groupsWorked)
                // TODO: persist `exercise` via ViewModel/Repository using Room
                navController.popBackStack()
            },
            enabled = name.isNotBlank() && selectedWorked.isNotEmpty()
        ) {
            Text("Save exercise")
        }
    }
}

