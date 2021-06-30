package de.kolpa.mc.inventorysorting.util

import net.kyori.adventure.text.Component
import org.bukkit.plugin.java.JavaPlugin

fun JavaPlugin.scheduleSyncDelayed(delay: Long, func: () -> Unit) {
    this.server.scheduler.scheduleSyncDelayedTask(this, func, delay)
}

fun String.toTextComponent() =
    Component.text(this)