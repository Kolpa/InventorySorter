package de.kolpa.mc.inventorysorting.processing.sorting

import org.bukkit.inventory.ItemStack

class AlphabeticInventorySorter : InventorySorter {
    override fun sortInventory(inventory: List<ItemStack>): List<ItemStack> {
        return inventory.sortedBy { it.i18NDisplayName }
    }
}