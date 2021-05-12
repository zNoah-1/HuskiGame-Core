package zkyubz.huskimc.core.game.testing;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.match.map.RestartQueue;
import zkyubz.huskimc.core.game.variables.GamePlayerList;
import zkyubz.huskimc.core.game.variables.Match;
import zkyubz.huskimc.core.game.variables.enums.MapState;

public class EndMatch {
    public static void call(){
        for (Player player : Bukkit.getWorld("testworld").getPlayers()){
            player.teleport(Bukkit.getWorld("world").getSpawnLocation());
        }

        Match match = MatchManager.getMatchList().get(0);
        match.setState(MapState.PENDING_RESTART);
        match.setCurrentPlayers(0);
        match.setPlayerList(new GamePlayerList());

        MatchManager.getMatchList().replace(0, match);

        RestartQueue.add(0);
    }
}
