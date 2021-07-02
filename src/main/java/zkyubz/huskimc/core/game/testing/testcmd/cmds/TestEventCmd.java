package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import zkyubz.huskimc.core.game.match.EventManager;
import zkyubz.huskimc.core.game.testing.TestEvents;
import zkyubz.huskimc.core.game.utils.ChatColor;
import zkyubz.huskimc.core.game.variables.HuskiGameEvent;

public class TestEventCmd implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (strings.length != 0){
            if (strings[0].equalsIgnoreCase("start")){
                TestEvents.init();
                commandSender.sendMessage(ChatColor.format("&cTest events initialized"));
            }
            else if (strings[0].equalsIgnoreCase("stop")){
                TestEvents.cancelAll();
                commandSender.sendMessage(ChatColor.format("&cTest events stopped"));
            }
            else if (strings[0].equalsIgnoreCase("debug")){
                commandSender.sendMessage("");
                commandSender.sendMessage(ChatColor.format("&cDebug:"));
                for (HuskiGameEvent huskiGameEvent : EventManager.getEventList()){
                    commandSender.sendMessage("gameId: " + huskiGameEvent.getGameId() + ", round: " + huskiGameEvent.getRound());
                }
                commandSender.sendMessage("");
            }
        }
        return true;
    }
}
