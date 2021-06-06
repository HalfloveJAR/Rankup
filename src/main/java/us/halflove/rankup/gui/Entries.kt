package us.halflove.rankup.gui

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import us.halflove.rankup.misc.LevelPerks

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object Entries {

    private fun getLore(level: Int): List<String> {
        return (LevelPerks.values().getOrNull(level - 1) ?: LevelPerks.LEVEL_OTHER).perks
    }

    fun getLevelItem(level: Int, player: Player): ItemStack {

        var levelItem = ItemStack(Material.GRAY_DYE, level)
        var levelMeta: ItemMeta? = levelItem.itemMeta
        var levelLore: ArrayList<String> = ArrayList()

        levelLore.add("")
        for(loreLine in getLore(level)) {
            levelLore.add(ChatColor.translateAlternateColorCodes('&', loreLine))
        }
        levelLore.add("")

        if(player.hasPermission("level.$level")){

            levelItem.type = Material.LIME_DYE
            levelMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&aLevel $level"))
            levelLore.add(ChatColor.translateAlternateColorCodes('&', "&aUnlocked!"))

        } else {

            levelMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7Level $level"))

            val levelMinusOne = level - 1
            if(player.hasPermission("level.$levelMinusOne")) {
                levelLore.add(ChatColor.translateAlternateColorCodes('&', "&eClick To Purchase!"))
            }else levelLore.add(ChatColor.translateAlternateColorCodes('&', "&cLocked."))

        }

        levelMeta?.lore = levelLore
        levelItem?.itemMeta = levelMeta
        return levelItem
    }

}