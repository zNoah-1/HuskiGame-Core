package zkyubz.huskimc.core.game.variables;

public class HuskiGameEvent {
    int gameId;
    int round;
    GameEvent gameEvent;
    //int taskId;
    //boolean isTaskActive;

    public HuskiGameEvent(int gameId, int round, GameEvent gameEvent){
        this.gameId = gameId;
        this.round = round;
        this.gameEvent = gameEvent;
    }

    public int getGameId() {
        return gameId;
    }

    public int getRound() {
        return round;
    }

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

    public GameEvent getGameEvent(){
        return gameEvent;
    }
}
