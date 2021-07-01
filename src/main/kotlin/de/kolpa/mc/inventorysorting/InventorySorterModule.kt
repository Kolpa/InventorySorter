package de.kolpa.mc.inventorysorting

import de.kolpa.mc.inventorysorting.handlers.InventoryMiddleClickHandler
import de.kolpa.mc.inventorysorting.processing.grouping.BaseInventoryGrouper
import de.kolpa.mc.inventorysorting.processing.grouping.InventoryGrouper
import de.kolpa.mc.inventorysorting.processing.sorting.AlphabeticInventorySorter
import de.kolpa.mc.inventorysorting.processing.sorting.InventorySorter
import org.koin.dsl.module

val inventorySortingModule = module {
    single<InventoryGrouper> { BaseInventoryGrouper() }
    single<InventorySorter> { AlphabeticInventorySorter() }
    single { InventoryMiddleClickHandler(get(), get(), get()) }
}