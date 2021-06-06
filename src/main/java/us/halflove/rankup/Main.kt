package us.halflove.rankup

import net.milkbowl.vault.economy.Economy
import net.milkbowl.vault.permission.Permission
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin
import us.halflove.rankup.commands.RankupCommand
import us.halflove.rankup.gui.ClickEvent
import us.halflove.rankup.storage.StorageFile


/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

class Main : JavaPlugin() {

    companion object {
        lateinit var econ: Economy
        lateinit var perms: Permission
    }

    override fun onEnable(){
        getCommand("rankup")?.setExecutor(RankupCommand())
        Bukkit.getPluginManager().registerEvents(ClickEvent(), this)
        setupEconomy()
        setupPermissions()
        StorageFile.createDataFile(this)
    }

    private fun setupEconomy(): Boolean {
        if (server.pluginManager.getPlugin("Vault") == null) {
            return false
        }
        val rsp = server.servicesManager.getRegistration(
            Economy::class.java
        ) ?: return false
        econ = rsp.provider
        return econ != null
    }

    private fun setupPermissions(): Boolean {
        val rsp = server.servicesManager.getRegistration(
            Permission::class.java
        )
        perms = rsp!!.provider
        return perms != null
    }

}