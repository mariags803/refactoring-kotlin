package es.leanmind.chests

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly

internal class FarmerShould : WordSpec({
    "Spell" should {
        "sort chests when they are empty" {
            val farmer = Farmer()
            val items = listOf(
                Item("wood", 5),
                Item("wood", 2),
                Item("stone", 3),
                Item("mushroom", 1),
                Item("wheat seed", 4),
                Item("potato seed", 2),
                Item("trout", 1),
                Item("cooper ore", 3)
            )
            val expectedSortedMaterials = listOf(
                Item("cooper ore", 3),
                Item("stone", 3),
                Item("wood", 5),
                Item("wood", 2),
            )
            val expectedSortedSeeds = listOf(
                Item("potato seed", 2),
                Item("wheat seed", 4),
            )
            val expectedSortedFood = listOf(
                Item("mushroom", 1),
                Item("trout", 1),
            )
            farmer.fill(items)

            farmer.spell()

            farmer.chest1 shouldContainExactly expectedSortedMaterials
            farmer.chest2 shouldContainExactly expectedSortedSeeds
            farmer.chest3 shouldContainExactly expectedSortedFood
        }

        "empty the backpack after sorting" {
            val farmer = Farmer()
            val items = listOf(
                Item("wood", 5),
                Item("wood", 2),
                Item("stone", 3),
                Item("mushroom", 1),
                Item("wheat seed", 4),
                Item("potato seed", 2),
                Item("trout", 1),
                Item("cooper ore", 3),
            )
            farmer.fill(items)

            farmer.spell()

            farmer.backpack.shouldBeEmpty()
        }

        "discards items that do not fit in chests" {
            val farmer = Farmer()
            val items1 = listOf(
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 2),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 3),
            )
            farmer.fill(items1)
            farmer.spell()

            val items2 = listOf(
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 4),
                Item("coal", 2),
            )
            farmer.fill(items2)
            farmer.spell()

            val items3 = listOf(
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("coal", 5),
                Item("coal", 5),
                Item("coal", 5),
                Item("cooper ore", 5),
            )
            farmer.fill(items3)

            farmer.spell()

            val expectedSortedMaterials = listOf(
                Item("coal", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 5),
                Item("stone", 2),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
                Item("wood", 5),
            )
            farmer.chest1 shouldContainExactly expectedSortedMaterials
        }
    }
})
