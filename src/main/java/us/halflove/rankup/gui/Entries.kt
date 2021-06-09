package us.halflove.rankup.gui

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.ItemMeta
import us.halflove.rankup.misc.LevelPerks
import us.halflove.rankup.misc.LevelPricesShort
import us.halflove.rankup.misc.LevelRanks

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

    private fun getPriceShort(level: Int): String{
        return (LevelPricesShort.values().getOrNull(level - 1) ?: LevelPricesShort.LEVEL_OTHER).price
    }

    fun getRank(level: Int): String{
        return (LevelRanks.values().getOrNull(level - 1) ?: LevelRanks.LEVEL_OTHER).rank
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
            levelMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&a" + getRank(level) + " &7" + getPriceShort(level)))
            levelLore.add(ChatColor.translateAlternateColorCodes('&', "&aUnlocked!"))

        } else {

            levelMeta?.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&7" + getRank(level) + " &6" + getPriceShort(level)))

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