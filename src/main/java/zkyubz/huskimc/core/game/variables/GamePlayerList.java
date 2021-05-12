package zkyubz.huskimc.core.game.variables;

import java.util.ArrayList;
import java.util.List;

public class GamePlayerList {
    List<GamePlayer> playerList = new ArrayList<>();

    public GamePlayerList(){
        //lol
    }

    //Do not rely on id to find an specific player
    public GamePlayer getPlayer(int id){
        return playerList.get(id);
    }

    public GamePlayer getPlayer(String playerName){
        for (GamePlayer gamePlayer : playerList){
            if (gamePlayer.getPlayerName().equals(playerName)){
                return gamePlayer;
            }
        }
        return null;
    }

    public void addPlayer(GamePlayer gamePlayer){
        playerList.add(gamePlayer);
    }
}
