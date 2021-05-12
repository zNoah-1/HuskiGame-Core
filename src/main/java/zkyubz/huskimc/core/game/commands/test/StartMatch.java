package zkyubz.huskimc.core.game.commands.test;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import zkyubz.huskimc.core.game.utils.ChatColor;

public class StartMatch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        zkyubz.huskimc.core.game.gaytesting.StartMatch.bigGay();
        return true;
    }
}
