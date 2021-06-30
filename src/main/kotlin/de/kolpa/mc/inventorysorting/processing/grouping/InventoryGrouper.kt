package de.kolpa.mc.inventorysorting.processing.grouping

import org.bukkit.inventory.ItemStack

interface InventoryGrouper {
    fun groupInventory(inventory: List<ItemStack>): List<ItemStack>
}