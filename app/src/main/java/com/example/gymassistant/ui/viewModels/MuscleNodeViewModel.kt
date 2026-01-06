package com.example.gymassistant.ui.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.gymassistant.ui.builders.MuscleTreeProvider
import com.example.gymassistant.ui.states.MuscleNodeModel

// TO REMOVE, NOT NEEDED -> use as example for exercise view-model
// The view-model will keep track of the ui state for an exercise
// database-connection will be handled in repository layer
//class MuscleNodeViewModel(
//    initialState: MuscleNodeModel = MuscleNodeModel()
//) : ViewModel() {
//    // Read-only cached muscle tree built once for the app process
//    val muscleTree: List<MuscleNodeModel> = MuscleTreeProvider.muscleTree
//
//    private val _uiState = MutableStateFlow(initialState)
//    val uiState: StateFlow<MuscleNodeModel> = _uiState.asStateFlow()
//
//    fun setState(state: MuscleNodeModel) {
//        _uiState.value = state
//    }
//
//    fun update(transform: (MuscleNodeModel) -> MuscleNodeModel) {
//        _uiState.value = transform(_uiState.value)
//    }
//}