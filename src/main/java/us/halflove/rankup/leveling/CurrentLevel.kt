package us.halflove.rankup.leveling

import org.bukkit.entity.Player

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

object CurrentLevel{

    fun getCurrentLevel(player: Player): String{

        var currentLevel: Int = 0
        for(level: Int in 1 until 12){
            if(player.hasPermission("level.$level")){
                currentLevel++
            }
        }
        return currentLevel.toString()

    }

}