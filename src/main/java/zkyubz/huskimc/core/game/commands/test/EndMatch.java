package zkyubz.huskimc.core.game.commands.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EndMatch implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        zkyubz.huskimc.core.game.testing.EndMatch.suckDick();
        return true;
    }
}