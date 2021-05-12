package zkyubz.huskimc.core.game.testing;

import org.bukkit.entity.Player;
import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.utils.ChatColor;
import zkyubz.huskimc.core.game.variables.enums.JoinResult;

public class JoinMatch {
    public static void noHomo(Player player){
        JoinResult result = MatchManager.joinMatchSolo(player, "test");

        switch (result){
            case MATCH_FULL: player.sendMessage(ChatColor.format("&cMatch full")); break;
            case JOINED: player.sendMessage(ChatColor.format("&aMatch joined")); break;
            case NOT_FOUND: player.sendMessage(ChatColor.format("&cMatch not found")); break;
            case GAME_STARTED: player.sendMessage(ChatColor.format("&cMatch already started")); break;
            case NO_PERMISSION: player.sendMessage(ChatColor.format("&cNo permission to join")); break;
            case GAME_RESTARTING: player.sendMessage(ChatColor.format("&cMatch is restarting")); break;
        }
    }
}
