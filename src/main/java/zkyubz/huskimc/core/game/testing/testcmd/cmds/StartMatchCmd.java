package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import zkyubz.huskimc.core.game.testing.StartMatch;

public class StartMatchCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        StartMatch.call();
        return true;
    }
}
