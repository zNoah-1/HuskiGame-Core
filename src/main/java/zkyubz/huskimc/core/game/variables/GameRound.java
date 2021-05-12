package zkyubz.huskimc.core.game.variables;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import zkyubz.huskimc.core.game.HGame;

public class GameRound {
    BukkitTask task;
    int gameId;
    int taskId;
    int timer;
    boolean isTaskActive;
    HuskiGameEvent huskiGameEvent;

    public GameRound(int gameId, int timer, HuskiGameEvent huskiGameEvent){
        this.gameId = gameId;
        this.timer = timer;
        this.huskiGameEvent = huskiGameEvent;
    }

    public void startTask(){
        task = new BukkitRunnable() {
            @Override
            public void run() {
                huskiGameEvent.getGameEvent().run();
            }
        }.runTaskLater(HGame.getInstance(), timer);

        taskId = task.getTaskId();
        isTaskActive = true;
    }

    public void cancel(){
        Bukkit.getScheduler().cancelTask(taskId);
    }
}
