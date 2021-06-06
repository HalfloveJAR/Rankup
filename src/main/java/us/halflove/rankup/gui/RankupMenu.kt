package us.halflove.rankup.gui

import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object RankupMenu {

    private fun getMenu(player: Player): Inventory{
        val menu: Inventory = Bukkit.createInventory(null, 27, "Rankup")

        var level = 1
        for(slot in 3 until 6){
            menu.setItem(slot, Entries.getLevelItem(level, player))
            level++
        }

        if(level == 4){
            for(slot in 11 until 16){
                menu.setItem(slot, Entries.getLevelItem(level, player))
                level++
            }
        }

        if(level == 9){
            for(slot in 21 until 24){
                menu.setItem(slot, Entries.getLevelItem(level, player))
                level++
            }
        }

        return menu
    }

    fun openMenu(player: Player){
        player.openInventory(getMenu(player))
    }

}