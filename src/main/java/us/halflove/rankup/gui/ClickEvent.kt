package us.halflove.rankup.gui

import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import us.halflove.rankup.leveling.Leveling

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class ClickEvent : Listener {

    @EventHandler
    fun clickEvent(event: InventoryClickEvent){

        val player: Player = event.whoClicked as Player

        if(event.view.title == "Rankup"){

            event.isCancelled = true

            for(level: Int in 1 until 12){
                if(event.currentItem != null) {
                    if (event.currentItem!! == Entries.getLevelItem(level, player)) {
                        val levelMinusOne: Int = level - 1
                        if (player.hasPermission("level.$levelMinusOne")) {
                            Leveling.attemptRankUp(player, level)
                        } else {
                            player.location.world!!.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_SNARE, 1f, 2f)
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou can't unlock that yet"))
                        }
                    }
                }
            }
        }

    }

}