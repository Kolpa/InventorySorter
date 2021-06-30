package de.kolpa.mc.inventorysorting

import de.kolpa.mc.inventorysorting.handlers.PlayerInteractionHandler
import de.kolpa.mc.inventorysorting.koin.KoinPlugin
import org.bukkit.event.HandlerList
import org.koin.core.component.inject

class InventorySorting : KoinPlugin(arrayOf(inventorySortingModule)) {
    override fun onEnable() {
        super.onEnable()

        val playerInteractionHandler by inject<PlayerInteractionHandler>()
        server.pluginManager.registerEvents(playerInteractionHandler, this)
    }

    override fun onDisable() {
        val playerInteractionHandler by inject<PlayerInteractionHandler>()
        HandlerList.unregisterAll(playerInteractionHandler)

        super.onDisable()
    }
}