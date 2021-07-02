package zkyubz.huskimc.core.game.variables;

public class GameEvent {
    int gameId;
    //int round;
    GameTask gameTask;
    //int taskId;
    //boolean isTaskActive;

    public GameEvent(int gameId, GameTask gameTask){
        this.gameId = gameId;
        this.gameTask = gameTask;
    }

    public int getGameId() {
        return gameId;
    }

    /*public int getRound() {
        return round;
    }*/

    /*public int getTaskId() {
        return taskId;
    }

    public boolean isTaskActive(){
        return isTaskActive;
    }

    public void setTaskId(int taskId){
        this.taskId = taskId;
    }

    public void setTaskActive(boolean taskActive) {
        isTaskActive = taskActive;
    }*/

    public GameTask getGameTask(){
        return gameTask;
    }
}
