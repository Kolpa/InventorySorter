package de.kolpa.mc.inventorysorting.handlers

import de.kolpa.mc.inventorysorting.processing.conditions.config.SortConditionSetFactory
import de.kolpa.mc.inventorysorting.processing.grouping.InventoryGrouper
import de.kolpa.mc.inventorysorting.processing.sorting.InventorySorter
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryOpenEvent


class PlayerInteractionHandler(
    private val inventoryGrouper: InventoryGrouper,
    private val inventorySorter: InventorySorter,
    private val sortConditionSetFactory: SortConditionSetFactory,
) : Listener {
    @EventHandler
    fun onPlayerUse(event: InventoryOpenEvent) {
        val conditions = sortConditionSetFactory.create()

        if (conditions.any { !it.shouldSort(event) }) {
            return
        }

        val inventory = event.view.topInventory

        val contents = inventory.contents.filterNotNull()

        val grouped = inventoryGrouper.groupInventory(contents)
        val sorted = inventorySorter.sortInventory(grouped)

        inventory.contents = sorted.toTypedArray()
    }
}