package zkyubz.huskimc.core.game.commands.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import zkyubz.huskimc.core.game.testing.AddMatch;
import zkyubz.huskimc.core.game.match.map.MapManager;

public class LoadTestMap implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        AddMatch.gayAss();
        return true;
    }

    public static void loadTestMap(CommandSender commandSender){
        MapManager.loadMap("testworld");
    }
}
