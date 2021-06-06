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

    LEVEL_ONE(listOf("&eBase Commands","&a50 Claim Blocks/Hour", "&b1 Sethome", "&21 Job")),
    LEVEL_TWO(listOf("&a60 Claim Blocks/Hour", "&b2 Sethomes")),
    LEVEL_THREE(listOf("&a70 Claim Blocks/Hour", "&22 Jobs", "&61 Auction House Item", "&d1 Common Key")),
    LEVEL_FOUR(listOf("&a80 Claim Blocks/Hour", "&b3 Sethomes")),
    LEVEL_FIVE(listOf("&a90 Claim Blocks/Hour", "&d2 Common Keys")),
    LEVEL_SIX(listOf("&a100 Claim Blocks/Hour", "&62 Auction House Items", "&b4 Sethomes")),
    LEVEL_SEVEN(listOf("&a110 Claim Blocks/Hour","&d3 Common Keys", "&5Silk Touch Mine Spawners")),
    LEVEL_EIGHT(listOf("&a120 Claim Blocks/Hour", "&63 Auction House Items", "&23 Jobs", "&d1 Rare Key")),
    LEVEL_NINE(listOf("&a130 Claim Blocks/Hour", "&64 Auction House Items", "&d1 Rare Key", "&b5 Sethomes", "&5Instant Teleportation")),
    LEVEL_TEN(listOf("&a140 Claim Blocks/Hour", "&65 Auction House Items", "&b6 Sethomes", "&5Custom Enchanting")),
    LEVEL_ELEVEN(listOf("&a150 Claim Blocks/Hour", "&66 Auction House Items", "&b7 Sethomes", "&24 Jobs", "&d1 Legendary Key")),
    LEVEL_OTHER(listOf(""))

}