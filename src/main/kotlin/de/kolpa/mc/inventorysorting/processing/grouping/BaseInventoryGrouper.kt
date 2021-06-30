package de.kolpa.mc.inventorysorting.processing.grouping

import org.bukkit.inventory.ItemStack

class BaseInventoryGrouper : InventoryGrouper {
    override fun groupInventory(inventory: List<ItemStack>): List<ItemStack> =
        inventory.group()

    companion object {
        private fun ItemStack.isFull() =
            this.amount == this.maxStackSize

        private fun Collection<ItemStack>.group(): List<ItemStack> {
            val result = mutableListOf<ItemStack>()
            this.forEach { itemStack ->
                val index = result.indexOfFirst { it.isSimilar(itemStack) && !it.isFull() }
                if (index != -1) {
                    val similarStack = result[index]
                    val combinedStackSize = similarStack.amount + itemStack.amount

                    if (combinedStackSize > itemStack.maxStackSize) {
                        // Create a new cloned stack for the overflow
                        val clonedStack = similarStack.clone()
                        clonedStack.amount = combinedStackSize - itemStack.maxStackSize
                        result += clonedStack

                        similarStack.amount = itemStack.maxStackSize
                    } else {
                        similarStack.amount = combinedStackSize
                    }
                    result[index] = similarStack
                } else {
                    result += itemStack
                }
            }
            return result.toList()
        }
    }
}