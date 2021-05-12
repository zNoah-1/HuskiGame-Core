package zkyubz.huskimc.core.game.variables;

import zkyubz.huskimc.core.game.variables.enums.MapState;

public class Match {
    int id;
    String name;
    String worldName;
    MapState state = MapState.DISABLED;
    int teamAmount;
    int currentPlayers = 0;
    int maxPlayers;
    boolean allowSpectating;
    int minPlayers;
    int roundAmount;
    SpawnPointList spawnPointList;
    GamePlayerList playerList = new GamePlayerList();

    public Match(int id, String name, String worldName, int teamAmount, int minPlayers, int maxPlayers, int roundAmount, boolean allowSpectating, SpawnPointList spawnPointList){
        this.id = id;
        this.name = name;
        this.worldName = worldName;
        this.teamAmount = teamAmount;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.roundAmount = roundAmount;
        this.allowSpectating = allowSpectating;
        this.spawnPointList = spawnPointList;
    }

    public Match(int id, String name, String worldName, MapState state, int teamAmount, int minPlayers, int maxPlayers, int roundAmount, boolean allowSpectating, SpawnPointList spawnPointList){
        this.id = id;
        this.name = name;
        this.worldName = worldName;
        this.state = state;
        this.teamAmount = teamAmount;
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.roundAmount = roundAmount;
        this.allowSpectating = allowSpectating;
        this.spawnPointList = spawnPointList;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getWorldName() {
        return this.worldName;
    }

    public MapState getState(){
        return this.state;
    }

    public int getTeamAmount(){
        return this.teamAmount;
    }

    public int getCurrentPlayers(){
        return this.currentPlayers;
    }

    public int getMaxPlayers(){
        return this.maxPlayers;
    }

    public boolean isAllowSpectating(){
        return this.allowSpectating;
    }

    public int getMinPlayers(){
        return this.minPlayers;
    }

    public SpawnPointList getSpawnPointList(){
        return this.spawnPointList;
    }

    public GamePlayerList getPlayerList(){
        return this.playerList;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setWorld(String worldName){
        this.worldName = worldName;
    }

    public void setState(MapState state){
        this.state = state;
    }

    public void setTeamAmount(int teamAmount){
        this.teamAmount = teamAmount;
    }

    public void setCurrentPlayers(int currentPlayers){
        this.currentPlayers = currentPlayers;
    }

    public void setMaxPlayers(int maxPlayers){
        this.maxPlayers = maxPlayers;
    }

    public void setAllowSpectating(boolean allowSpectating){
        this.allowSpectating = allowSpectating;
    }

    public void setMinPlayers(int minPlayers){
        this.minPlayers = minPlayers;
    }

    public void setSpawnPoints(SpawnPointList spawnPointList){
        this.spawnPointList = spawnPointList;
    }

    public void setPlayerList(GamePlayerList playerList){
        this.playerList = playerList;
    }
}
