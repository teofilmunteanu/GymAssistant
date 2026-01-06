package com.example.gymassistant.ui.builders

import com.example.gymassistant.constants.MuscleGroup
import com.example.gymassistant.constants.muscleHierarchy
import com.example.gymassistant.ui.states.MuscleNodeModel

/**
 * Builds a tree of `MuscleNodeModel` from the `muscleHierarchy` constants.
 * The provider below caches the result so it's only built once per process.
 */
fun buildMuscleTree(roots: List<Enum<*>> = MuscleGroup.entries): List<MuscleNodeModel> {
    fun buildNode(value: Enum<*>): MuscleNodeModel {
        val childrenEnums = muscleHierarchy[value].orEmpty()
        val childrenModels = childrenEnums.map { child -> buildNode(child) }
        return MuscleNodeModel(
            value = value,
            subgroups = childrenModels
        )
    }

    return roots.map { root -> buildNode(root) }
}

object MuscleTreeProvider {
    val muscleTree: List<MuscleNodeModel> by lazy { buildMuscleTree() }
}
