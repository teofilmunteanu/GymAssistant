package com.example.gymassistant.ui.viewModels

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.gymassistant.ui.builders.MuscleTreeProvider
import com.example.gymassistant.ui.states.MuscleNodeUiState

// TO REMOVE, NOT NEEDED -> use as example for exercise view-model
// The view-model will keep track of the ui state for an exercise
// database-connection will be handled in repository layer
//class MuscleNodeViewModel(
//    initialState: MuscleNodeUiState = MuscleNodeUiState()
//) : ViewModel() {
//    // Read-only cached muscle tree built once for the app process
//    val muscleTree: List<MuscleNodeUiState> = MuscleTreeProvider.muscleTree
//
//    private val _uiState = MutableStateFlow(initialState)
//    val uiState: StateFlow<MuscleNodeUiState> = _uiState.asStateFlow()
//
//    fun setState(state: MuscleNodeUiState) {
//        _uiState.value = state
//    }
//
//    fun update(transform: (MuscleNodeUiState) -> MuscleNodeUiState) {
//        _uiState.value = transform(_uiState.value)
//    }
//}