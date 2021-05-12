package zkyubz.huskimc.core.game.commands.test;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import zkyubz.huskimc.core.game.utils.ChatColor;

public class ReloadMap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Bukkit.unloadWorld(Bukkit.getWorld("testworld"), true);
        LoadTestMap.loadTestMap(commandSender);
        return true;
    }
}
