package de.kolpa.mc.inventorysorting

import de.kolpa.mc.inventorysorting.handlers.PlayerInteractionHandler
import de.kolpa.mc.inventorysorting.processing.conditions.IsContainerSortCondition
import de.kolpa.mc.inventorysorting.processing.conditions.OnCopperSortCondition
import de.kolpa.mc.inventorysorting.processing.conditions.config.SortConditionSetFactory
import de.kolpa.mc.inventorysorting.processing.grouping.BaseInventoryGrouper
import de.kolpa.mc.inventorysorting.processing.grouping.InventoryGrouper
import de.kolpa.mc.inventorysorting.processing.sorting.AlphabeticInventorySorter
import de.kolpa.mc.inventorysorting.processing.sorting.InventorySorter
import org.koin.dsl.module

val inventorySortingModule = module {
    single { OnCopperSortCondition() }
    single { IsContainerSortCondition() }
    single { SortConditionSetFactory(get(), get()) }
    single<InventoryGrouper> { BaseInventoryGrouper() }
    single<InventorySorter> { AlphabeticInventorySorter() }
    single { PlayerInteractionHandler(get(), get(), get()) }
}