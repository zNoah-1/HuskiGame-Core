package zkyubz.huskimc.core.game.variables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import zkyubz.huskimc.core.game.HGame;
import zkyubz.huskimc.core.game.match.EventManager;

public class HuskiGameEvent extends GameEvent {
    BukkitTask task;
    int gameId;
    int round;
    int taskId;
    int timer;
    boolean isTaskActive;
    //GameEvent gameEvent;

    public HuskiGameEvent(int gameId, int round, int timer, GameTask gameTask){
        super(gameId, gameTask);

        this.gameId = gameId;
        this.round = round;
        this.timer = timer;
        //this.gameEvent = gameEvent;
    }

    public int getGameId(){
        return gameId;
    }

    public int getRound(){
        return round;
    }

    public int getTaskId(){
        return taskId;
    }

    public void startTask(){
        task = new BukkitRunnable() {
            @Override
            public void run() {
                getGameTask().run();
                EventManager.removeEvent(this.getTaskId());
            }
        }.runTaskLater(HGame.getInstance(), timer);

        taskId = task.getTaskId();
        isTaskActive = true;
    }

    public void cancel(){
        Bukkit.getScheduler().cancelTask(taskId);
        isTaskActive = false;
    }
}
