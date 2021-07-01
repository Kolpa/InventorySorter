package de.kolpa.mc.inventorysorting.handlers

import de.kolpa.mc.inventorysorting.processing.grouping.InventoryGrouper
import de.kolpa.mc.inventorysorting.processing.sorting.InventorySorter
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.ClickType
import org.bukkit.event.inventory.InventoryClickEvent
import java.util.logging.Logger

class InventoryMiddleClickHandler(
    private val inventoryGrouper: InventoryGrouper,
    private val inventorySorter: InventorySorter,
    private val logger: Logger,
) : Listener {
    @EventHandler
    fun onInventoryClick(event: InventoryClickEvent) {
        logger.info("InventoryClickEvent triggered by player: ${event.whoClicked.name}")

        if (event.click != ClickType.MIDDLE) {
            logger.info("ClickType was not MIDDLE ignoring")
            return
        }

        val inventory = event.clickedInventory ?: return

        logger.info("got inventory from event")

        val contents = inventory.contents.filterNotNull()

        logger.info("Found an inventory with ${contents.size} stacks")

        val grouped = inventoryGrouper.groupInventory(contents)

        logger.info("${grouped.size} stacks left after grouping")

        val sorted = inventorySorter.sortInventory(grouped)

        inventory.contents = sorted.toTypedArray()

        logger.info("sorting finished")
    }
}