package de.kolpa.mc.inventorysorting.processing.conditions

import org.bukkit.Material
import org.bukkit.block.BlockFace
import org.bukkit.event.inventory.InventoryOpenEvent

class OnCopperSortCondition : SortCondition {
    override fun shouldSort(inventoryOpenEvent: InventoryOpenEvent): Boolean {
        return inventoryOpenEvent
            .view
            .topInventory
            .location
            ?.block
            ?.getRelative(BlockFace.DOWN)
            ?.blockData
            ?.material == Material.COPPER_BLOCK
    }
}