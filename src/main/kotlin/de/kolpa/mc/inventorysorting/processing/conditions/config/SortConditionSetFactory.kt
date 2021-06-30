package de.kolpa.mc.inventorysorting.processing.conditions.config

import de.kolpa.mc.inventorysorting.processing.conditions.IsContainerSortCondition
import de.kolpa.mc.inventorysorting.processing.conditions.OnCopperSortCondition
import de.kolpa.mc.inventorysorting.processing.conditions.SortCondition

class SortConditionSetFactory(
    private val isContainerSortCondition: IsContainerSortCondition,
    private val onCopperSortCondition: OnCopperSortCondition,
) {
    fun create(): Set<SortCondition> =
        setOf(isContainerSortCondition, onCopperSortCondition)
}