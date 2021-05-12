package zkyubz.huskimc.core.game.testing;

import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.variables.enums.MapState;

public class StartMatch {
    public static void call() {
        MatchManager.getMatchList().get(0).setState(MapState.INGAME);
    }
}
