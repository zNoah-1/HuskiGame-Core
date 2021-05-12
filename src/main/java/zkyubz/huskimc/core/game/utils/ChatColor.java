package zkyubz.huskimc.core.game.utils;

public class ChatColor {
    public static String format(String text){
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', text);
    }
}
