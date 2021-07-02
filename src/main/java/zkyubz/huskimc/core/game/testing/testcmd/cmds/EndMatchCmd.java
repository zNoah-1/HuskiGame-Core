package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import zkyubz.huskimc.core.game.testing.EndMatch;

public class EndMatchCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        EndMatch.call();
        return true;
    }
}