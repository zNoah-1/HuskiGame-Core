package zkyubz.huskimc.core.game.match;

import zkyubz.huskimc.core.game.variables.GameTask;
import zkyubz.huskimc.core.game.variables.HuskiGameEvent;

import java.util.ArrayList;
import java.util.List;

public class EventManager {
    static List<HuskiGameEvent> eventList = new ArrayList<>();

    public static void addEvent(int gameId, int round, int timer, GameTask gameTask){
        HuskiGameEvent huskiGameEvent = new HuskiGameEvent(gameId, round, timer, gameTask);
        eventList.add(huskiGameEvent);
    }

    public static void initEvents(int gameId){
        for (HuskiGameEvent round : eventList){
            if (round.getGameId() == gameId){
                round.startTask();
            }
        }
    }

    public static void removeEvents(int gameId){
        List<Integer> eventsToRemove = new ArrayList<>();

        HuskiGameEvent huskiGameEvent;
        for (int i = 0; i < eventList.size(); ++i){
            huskiGameEvent = eventList.get(i);

            if (huskiGameEvent.getGameId() == gameId){
                huskiGameEvent.cancel();
                eventsToRemove.add(i);
            }
        }

        int offset = 0;
        for (int eventId : eventsToRemove){
            eventList.remove(eventId + offset);
            offset--;
        }
    }

    public static void removeEvent(int taskId){
        eventList.removeIf(huskiGameEvent -> huskiGameEvent.getTaskId() == taskId);
    }

    public static List<HuskiGameEvent> getEventList(){
        return eventList;
    }

}
