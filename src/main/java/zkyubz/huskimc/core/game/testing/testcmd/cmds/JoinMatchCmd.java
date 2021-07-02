package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;
import zkyubz.huskimc.core.game.testing.JoinMatch;

public class JoinMatchCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        JoinMatch.call((Player)commandSender);
        return true;
    }
}
