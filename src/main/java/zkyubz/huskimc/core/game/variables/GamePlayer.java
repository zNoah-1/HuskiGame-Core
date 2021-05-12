package zkyubz.huskimc.core.game.variables;

public class GamePlayer {
    String playerName;
    int teamId = -1;
    boolean playerEliminated = false;

    public GamePlayer(String playerName){
        this.playerName = playerName;
    }

    public GamePlayer(String playerName, int teamId){
        this.playerName = playerName;
        this.teamId = teamId;
    }

    public String getPlayerName(){
        return this.playerName;
    }

    public int getTeamId(){
        return this.teamId;
    }

    public boolean isPlayerEliminated(){
        return this.playerEliminated;
    }

    public void setPlayerEliminated(){
        playerEliminated = true;
    }

    public void setTeamId(int teamId){
        this.teamId = teamId;
    }
}
