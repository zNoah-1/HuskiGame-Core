package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ReloadMapCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Bukkit.unloadWorld(Bukkit.getWorld("testworld"), true);
        LoadTestMapCmd.loadTestMap(commandSender);
        return true;
    }
}
