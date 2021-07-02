package zkyubz.huskimc.core.game.testing.testcmd.cmds;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import zkyubz.huskimc.core.game.testing.AddMatch;
import zkyubz.huskimc.core.game.match.map.MapManager;

public class LoadTestMapCmd implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        AddMatch.call();
        return true;
    }

    public static void loadTestMap(CommandSender commandSender){
        MapManager.loadMap("testworld");
    }
}
