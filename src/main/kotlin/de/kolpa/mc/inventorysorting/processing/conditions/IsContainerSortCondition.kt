package de.kolpa.mc.inventorysorting.processing.conditions

import org.bukkit.event.inventory.InventoryOpenEvent
import org.bukkit.event.inventory.InventoryType

class IsContainerSortCondition : SortCondition {
    override fun shouldSort(inventoryOpenEvent: InventoryOpenEvent): Boolean {
        repeat(inventoryOpenEvent.view.topInventory.size) {
            if (inventoryOpenEvent.view.getSlotType(it) != InventoryType.SlotType.CONTAINER) {
                return false
            }
        }
        return true
    }
}