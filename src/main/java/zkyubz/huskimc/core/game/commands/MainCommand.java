package zkyubz.huskimc.core.game.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import zkyubz.huskimc.core.game.utils.ChatColor;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.format(" "));
        commandSender.sendMessage(ChatColor.format("       &b&lHuskiCore-Game  "));
        commandSender.sendMessage(ChatColor.format("  "));
        commandSender.sendMessage(ChatColor.format(" ➜ &fCreado por &bNua#1962"));
        commandSender.sendMessage(ChatColor.format(" ➜ &fPara: &aTodos uwu"));
        commandSender.sendMessage(ChatColor.format(" "));
        return true;
    }
}
