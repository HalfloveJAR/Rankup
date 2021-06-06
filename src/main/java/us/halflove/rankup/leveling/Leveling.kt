package us.halflove.rankup.leveling

import org.bukkit.Bukkit
import org.bukkit.ChatColor
import org.bukkit.Sound
import org.bukkit.entity.Player
import us.halflove.rankup.Main
import us.halflove.rankup.gui.RankupMenu
import us.halflove.rankup.misc.LevelPerks
import us.halflove.rankup.misc.LevelPrices
import us.halflove.rankup.storage.StorageFile
import kotlin.math.roundToInt

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object Leveling {

    fun attemptRankUp(player: Player, level: Int){

        val currentBal = Main.econ.getBalance(player).roundToInt()
        val levelPrice = (LevelPrices.values().getOrNull(level - 1) ?: LevelPrices.LEVEL_OTHER).price
        if(currentBal >= levelPrice){
            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6&l${player.name} has reached level ${level}!"))
            player.location.world!!.playSound(player.location, Sound.UI_TOAST_CHALLENGE_COMPLETE, 1f, 1f)
            Main.econ.withdrawPlayer(player, levelPrice)
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c-$$levelPrice"))
            Main.perms.playerAdd(player, "level.$level")
            RankupMenu.openMenu(player)
            for(command: String in StorageFile.data.get("$level.reward") as List<String>){
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
            }
        }else{
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou need $$levelPrice for that, you only have $$currentBal"))
            player.location.world!!.playSound(player.location, Sound.BLOCK_NOTE_BLOCK_SNARE, 1f, 2f)
        }

    }

}