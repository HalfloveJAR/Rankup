package us.halflove.rankup

import org.bukkit.plugin.java.JavaPlugin
import us.halflove.rankup.commands.RankupCommand

/*
*
* @author Halflove
*
* https://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class Main : JavaPlugin() {

    override fun onEnable(){
        getCommand("rankup")?.setExecutor(RankupCommand())
    }

}