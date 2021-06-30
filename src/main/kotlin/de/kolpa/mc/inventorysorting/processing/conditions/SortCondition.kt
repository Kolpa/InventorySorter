package de.kolpa.mc.inventorysorting.processing.conditions

import org.bukkit.event.inventory.InventoryOpenEvent

interface SortCondition {
    fun shouldSort(inventoryOpenEvent: InventoryOpenEvent): Boolean
}