package de.kolpa.mc.inventorysorting.processing.sorting

import org.bukkit.inventory.ItemStack

interface InventorySorter {
    fun sortInventory(inventory: List<ItemStack>): List<ItemStack>
}