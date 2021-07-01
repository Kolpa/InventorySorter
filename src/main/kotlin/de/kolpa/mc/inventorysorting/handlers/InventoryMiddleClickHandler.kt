package de.kolpa.mc.inventorysorting.handlers

import de.kolpa.mc.inventorysorting.processing.grouping.InventoryGrouper
import de.kolpa.mc.inventorysorting.processing.sorting.InventorySorter
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryMiddleClickHandler(
    private val inventoryGrouper: InventoryGrouper,
    private val inventorySorter: InventorySorter,
) : Listener {
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        if (event.click != ClickType.MIDDLE) {
            return
        }

        val inventory = event.clickedInventory ?: return

        val contents = inventory.contents.filterNotNull()

        val grouped = inventoryGrouper.groupInventory(contents)
        val sorted = inventorySorter.sortInventory(grouped)

        inventory.contents = sorted.toTypedArray()
    }
}