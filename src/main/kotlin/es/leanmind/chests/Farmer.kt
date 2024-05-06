package es.leanmind.chests

class Farmer {
    val backpack = mutableListOf<Item>()
    val chest1 = mutableListOf<Item>()
    val chest2 = mutableListOf<Item>()
    val chest3 = mutableListOf<Item>()

    fun fill(items: List<Item>) {
        for (i in items.indices) {
            if (backpack.size < 16) {
                backpack.add(items[i])
            }
        }
    }

    fun spell() {
        backpack.forEach { item ->
            when (item.name) {
                "wood", "stone", "coal", "cooper ore", "iron ore" -> {
                    val items1 = chest1.stream().filter { chestItem: Item -> chestItem.name == item.name }.toList()
                    // if not exist any item with the same name, add the item to the chest
                    if (items1.isEmpty() && chest1.size < 16) {
                        chest1.add(item)
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (i in items1.indices) {
                            if (items1[i].quantity < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.quantity != 0 && items1[i].quantity < 5) {
                                    items1[i].quantity += 1
                                    item.quantity -= 1
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.quantity != 0 && chest1.size < 16) {
                            chest1.add(item)
                        }
                    }
                }

                "wheat seed", "potato seed", "carrot seed", "corn seed", "kale seed" -> {
                    val items2 = chest2.stream().filter { chestItem: Item -> chestItem.name == item.name }.toList()
                    // if not exist any item with the same name, add the item to the chest
                    if (items2.isEmpty() && chest2.size < 16) {
                        chest2.add(item)
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (i in items2.indices) {
                            if (items2[i].quantity < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.quantity != 0 && items2[i].quantity < 5) {
                                    items2[i].quantity += 1
                                    item.quantity -= 1
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.quantity != 0 && chest2.size < 16) {
                            chest2.add(item)
                        }
                    }
                }

                "raspberry", "apricot", "wild onion", "mushroom", "trout" -> {
                    val items3 = chest3.stream().filter { chestItem: Item -> chestItem.name == item.name }.toList()
                    // if not exist any item with the same name, add the item to the chest
                    if (items3.isEmpty() && chest3.size < 16) {
                        chest3.add(item)
                        // if the item is already in the chest, check if the quantity is less than 5
                    } else {
                        for (i in items3.indices) {
                            if (items3[i].quantity < 5) {
                                //increment the quantity of the item in the chest while the quantity of the item in the chest is less
                                //than 5 and decrease the quantity of the item in the bag
                                while (item.quantity != 0 && items3[i].quantity < 5) {
                                    items3[i].quantity += 1
                                    item.quantity -= 1
                                }
                            }
                        }
                        // if the quantity of the item in the bag is not 0, add the item to the chest if it fit
                        if (item.quantity != 0 && chest3.size < 16) {
                            chest3.add(item)
                        }
                    }
                }

                else -> {
                    // if the object not in the list, do nothing
                }
            }
        }

        chest1.sortBy(Item::name)
        chest2.sortBy(Item::name)
        chest3.sortBy(Item::name)

        backpack.clear()
    }
}