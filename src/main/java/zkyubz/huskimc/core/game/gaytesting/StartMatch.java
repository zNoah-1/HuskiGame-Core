package zkyubz.huskimc.core.game.gaytesting;

import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.variables.enums.MapState;

public class StartMatch {
    public static void bigGay() {
        MatchManager.getMatchList().get(0).setState(MapState.INGAME);
    }
}
