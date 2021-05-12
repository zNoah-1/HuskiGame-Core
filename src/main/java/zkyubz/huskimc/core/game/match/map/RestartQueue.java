package zkyubz.huskimc.core.game.match.map;

import org.bukkit.scheduler.BukkitRunnable;
import zkyubz.huskimc.core.game.HGame;
import zkyubz.huskimc.core.game.match.MatchManager;
import zkyubz.huskimc.core.game.variables.Match;
import zkyubz.huskimc.core.game.variables.enums.MapState;

import java.util.ArrayList;
import java.util.List;

public class RestartQueue {
    static List<Integer> queueList = new ArrayList<>();
    static boolean taskRunning;

    public static void init(){
        startTask();
        taskRunning = true;
    }

    public static void add(int id){
        queueList.add(id);
        if (!taskRunning){
            System.out.println("task stopped, trying to restart it");
            startTask();
        }
    }

    public static BukkitRunnable getRunnable(){
        return new BukkitRunnable() {
            @Override
            public void run() {
                System.out.println("cicle");
                if (queueList.size() == 0) {
                    System.out.println("size 0");
                    taskRunning = false;
                    System.out.println("trying to cancel task");
                    this.cancel();
                }
                else {
                    System.out.println("trying to reload a map");
                    int id = queueList.get(0);
                    Match match = MatchManager.getMatchList().get(id);
                    String worldName = match.getWorldName();
                    System.out.println("map name: " + worldName);

                    MapManager.reloadMap(worldName);
                    match.setState(MapState.WAITING);

                    MatchManager.getMatchList().replace(id, match);
                    queueList.remove((Object)id);
                }
            }
        };
    }

    static void startTask(){
        System.out.println("trying to start task");
        getRunnable().runTaskTimerAsynchronously(HGame.getInstance(), 40L, 40L);
    }
}
