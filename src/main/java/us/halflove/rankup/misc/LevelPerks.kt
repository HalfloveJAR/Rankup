package us.halflove.rankup.misc

/*
*
* @author Halflove
*
* http://Halflove.us
* https://github.com/HalfloveJAR
*
*/

enum class LevelPerks(val perks: List<String>) {

    LEVEL_ONE(listOf("&eBase Commands", "&b1 Sethome", "&21 Job")),
    LEVEL_TWO(listOf("&b2 Sethomes")),
    LEVEL_THREE(listOf("&22 Jobs", "&61 Auction House Item", "&d1 Common Key")),
    LEVEL_FOUR(listOf("&b3 Sethomes")),
    LEVEL_FIVE(listOf("&d2 Common Keys")),
    LEVEL_SIX(listOf("&62 Auction House Items", "&b4 Sethomes")),
    LEVEL_SEVEN(listOf("&d3 Common Keys", "&5Silk Touch Mine Spawners")),
    LEVEL_EIGHT(listOf("&63 Auction House Items", "&23 Jobs", "&d1 Rare Key")),
    LEVEL_NINE(listOf("&64 Auction House Items", "&d1 Rare Key", "&b5 Sethomes", "&5Instant Teleportation")),
    LEVEL_TEN(listOf("&65 Auction House Items", "&b6 Sethomes", "&5Custom Enchanting")),
    LEVEL_ELEVEN(listOf("&66 Auction House Items", "&b7 Sethomes", "&24 Jobs", "&d1 Legendary Key")),
    LEVEL_OTHER(listOf(""))

}