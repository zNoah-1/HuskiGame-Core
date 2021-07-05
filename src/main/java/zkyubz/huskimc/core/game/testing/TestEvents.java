package zkyubz.huskimc.core.game.testing;

import zkyubz.huskimc.core.game.match.EventManager;
import zkyubz.huskimc.core.game.testing.events.TaskOne;
import zkyubz.huskimc.core.game.testing.events.TaskTwo;

public class TestEvents {
    public static void init(){
        addEventOne();
        addEventTwo();

        EventManager.initEvents(0);
    }

    public static void cancelAll(){
        EventManager.removeEvents(0);
    }

    private static void addEventOne(){
        EventManager.addEvent(0, 1, 200, new TaskOne());
    }

    private static void addEventTwo(){
        EventManager.addEvent(0, 2, 400, new TaskTwo());
    }
}
