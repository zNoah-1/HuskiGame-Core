package zkyubz.huskimc.core.game.testing;

import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.variables.SpawnPoint;
import zkyubz.huskimc.core.game.variables.SpawnPointList;
import zkyubz.huskimc.core.game.variables.enums.MapState;

public class AddMatch {
    public static void call() {
        String name = "test";
        String worldName = "testworld";
        MapState state = MapState.WAITING;
        int teamAmount = 1;
        int minPlayers = 2;
        int maxPlayers = 2;
        int rounds = 0;
        boolean allowSpectating = false;
        SpawnPointList spawnPoints = new SpawnPointList();

        spawnPoints.add(0, new SpawnPoint(4, 4, 4, 0, 0));
        spawnPoints.add(1, new SpawnPoint(-4, 4, -4, 0, 0));

        MatchManager.addMatch(0, name, worldName, state, teamAmount, minPlayers, maxPlayers, rounds, allowSpectating, spawnPoints);

    }
}
