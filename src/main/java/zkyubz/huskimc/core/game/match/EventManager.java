package zkyubz.huskimc.core.game.match;

import zkyubz.huskimc.core.game.variables.GameRound;
import zkyubz.huskimc.core.game.variables.HuskiGameEvent;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    static List<GameRound> eventList = new ArrayList<>();

    public static void addRound(int gameId, int timer, HuskiGameEvent huskiGameEvent){
        GameRound gameRound = new GameRound(gameId, timer, huskiGameEvent);
        eventList.add(gameRound);
    }

    public static void addEvent(HuskiGameEvent huskiGameEvent, int round){

    }

    public static void removeEventsMatch(String worldName){

    }

}
