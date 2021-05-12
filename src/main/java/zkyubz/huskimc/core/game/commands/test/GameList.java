package zkyubz.huskimc.core.game.commands.test;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.utils.ChatColor;
import zkyubz.huskimc.core.game.variables.Match;

public class GameList implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        commandSender.sendMessage(ChatColor.format(""));
        commandSender.sendMessage(ChatColor.format("&6List of matches: "));
        for (int i = 0; i < MatchManager.getMatchList().size(); ++i){
            commandSender.sendMessage(ChatColor.format("&f" + MatchManager.getMatchList().get(i).getId() + ". " + MatchManager.getMatchList().get(i).getName()));
            commandSender.sendMessage(MatchManager.getMatchList().get(i).getWorldName());
            commandSender.sendMessage(Integer.toString(MatchManager.getMatchList().get(i).getCurrentPlayers()));
            commandSender.sendMessage(Integer.toString(MatchManager.getMatchList().get(i).getMinPlayers()));
            commandSender.sendMessage(Integer.toString(MatchManager.getMatchList().get(i).getMaxPlayers()));
            commandSender.sendMessage(Integer.toString(MatchManager.getMatchList().get(i).getTeamAmount()));
            commandSender.sendMessage(String.valueOf(MatchManager.getMatchList().get(i).getState()));
            commandSender.sendMessage("");
        }
        commandSender.sendMessage(ChatColor.format(""));
        return true;
    }
}
