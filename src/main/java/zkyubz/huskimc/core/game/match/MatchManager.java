package zkyubz.huskimc.core.game.match;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import zkyubz.huskimc.core.game.match.map.MapManager;
import zkyubz.huskimc.core.game.variables.*;
import zkyubz.huskimc.core.game.variables.enums.JoinResult;
import zkyubz.huskimc.core.game.variables.enums.MapState;
import zkyubz.huskimc.core.game.variables.exceptions.SpawnPointNotFoundException;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MatchManager {
    /*
    * If you choose a single thread access use HashMap, it is simply faster.
    * For add method it is even as much as 3x more efficient.
    * Only get is faster on ConcurrentHashMap, but not much.
    *
    * https://stackoverflow.com/questions/1378310/performance-concurrenthashmap-vs-hashmap
    * */
    static Map<Integer, Match> matchList = new ConcurrentHashMap<>();
    static GamePlayerList playerInMatchList = new GamePlayerList();

    public static Map<Integer, Match> getMatchList (){
        return matchList;
    }

    public static JoinResult joinMatchSolo(Player player, String name){
        LinkedList<Match> matchSameName = new LinkedList<>();
        for (Match match : matchList.values()){
            if (match.getName().equals(name)){
                matchSameName.add(match);
            }
        }

        if (matchSameName.size() == 0){
            return JoinResult.NOT_FOUND;
        }

        int matchMostPlayers = 0;
        boolean foundMatch = false;

        for (int i = 0; i < matchSameName.size(); ++i){
            Match match = matchSameName.get(i);
            if (match.getState().equals(MapState.WAITING) || match.getState().equals(MapState.STARTING)){
                if (match.getCurrentPlayers() > matchSameName.get(matchMostPlayers).getCurrentPlayers()){
                    matchMostPlayers = i;
                }
                foundMatch = true;
            }
        }

        if (foundMatch){
            //join this match:
            //matchSameName.get(matchMostPlayers);
            try {
                joinMatch(player, matchSameName.get(matchMostPlayers).getId());
            }
            catch (Exception e){
                e.printStackTrace();
                return JoinResult.JOIN_ERROR;
            }
            return JoinResult.JOINED;
        }
        else {
            return JoinResult.NOT_AVAILABLE;
            //No match available, game plugin should handle this message
        }
    }

    /*public static JoinResult joinMatchTeam(Player player, String name){
        LinkedList<Match> matchSameName = new LinkedList<>();
        for (Match match : matchList.values()){
            if (match.getName().equals(name)){
                matchSameName.add(match);
            }
        }

        int matchMostPlayers = 0;
        boolean foundMatch = false;

        for (int i = 0; i < matchSameName.size(); ++i){
            Match match = matchSameName.get(i);
            if (match.getState().equals(MapState.WAITING) || match.getState().equals(MapState.STARTING)){
                if (match.getCurrentPlayers() != match.getMaxPlayers() && match.getCurrentPlayers() > matchSameName.get(matchMostPlayers).getCurrentPlayers()){
                    matchMostPlayers = i;
                    foundMatch = true;
                }
            }
        }

        if (foundMatch){
            //join this match:
            //matchSameName.get(matchMostPlayers);
            joinMatch(player, matchSameName.get(matchMostPlayers).getId());
            return JoinResult.JOINED;
        }
        else {
            return JoinResult.NOT_FOUND;
            //No match available, game plugin should handle this message
        }
    }*/

    public static JoinResult joinMatchSolo(Player player, int id){
        Match match = matchList.get(id);

        //Not using switch to keep code consistency

        if (match.getState().equals(MapState.WAITING) || match.getState().equals(MapState.STARTING)){
            //join Match
            try {
                joinMatch(player, id);
            }
            catch (Exception e){
                e.printStackTrace();
                return JoinResult.JOIN_ERROR;
            }
            return JoinResult.JOINED;
        }
        else if (match.getState().equals(MapState.STARTING_FULL)){
            //Match already full, game plugin should handle this message
            return JoinResult.MATCH_FULL;
        }
        else if (match.getState().equals(MapState.INGAME)){
            //Match already started, game plugin should handle this message
            return JoinResult.GAME_STARTED;
        }
        else {
            //Match restarting, game plugin should handle this message
            return JoinResult.GAME_RESTARTING;
        }
    }

    private static void joinMatch(Player player, int id) throws SpawnPointNotFoundException {
        Match match = matchList.get(id);
        int playerAmount = match.getCurrentPlayers();
        SpawnPoint spawnPoint = match.getSpawnPointList().getSpawnPoint(playerAmount);

        try {
            player.teleport(new Location(Bukkit.getWorld(match.getWorldName()), spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), spawnPoint.getYaw(), spawnPoint.getPitch()));
            matchList.get(id).setCurrentPlayers(playerAmount + 1);

            if (matchList.get(id).getCurrentPlayers() == match.getMaxPlayers()){
                matchList.get(id).setState(MapState.STARTING_FULL);
            }
        }
        catch (NullPointerException e){
            if (spawnPoint == null){
                throw new SpawnPointNotFoundException("Can't find spawn point with id: " + playerAmount);
            }
        }

    }

    private static void joinMatchWithoutTeleport(Player player, int id){
        Match match = matchList.get(id);
        int playerAmount = match.getCurrentPlayers();
        SpawnPoint spawnPoint = match.getSpawnPointList().getSpawnPoint(playerAmount);

        //player.teleport(new Location(Bukkit.getWorld(match.getWorldName()), spawnPoint.getX(), spawnPoint.getY(), spawnPoint.getZ(), spawnPoint.getYaw(), spawnPoint.getPitch()));
        matchList.get(id).setCurrentPlayers(playerAmount + 1);

        if (matchList.get(id).getCurrentPlayers() == match.getMaxPlayers()){
            matchList.get(id).setState(MapState.STARTING_FULL);
        }
    }


    /*public static void addMatch(String name, String worldName, int teamAmount, int minPlayers, int maxPlayers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(matchList.size(), name, worldName, teamAmount, minPlayers, maxPlayers, allowSpectating, spawnPoints);
        matchList.put(matchList.size(), match);
    }

    public static void addMatch(int id, String name, String worldName, int teamAmount, int minPlayers, int maxPlayers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(id, name, worldName, teamAmount, minPlayers, maxPlayers, allowSpectating, spawnPoints);
        matchList.put(id, match);
    }

    public static void addMatch(String name, String worldName, MapState mapState, int teamAmount, int minPlayers, int maxPlayers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(matchList.size(), name, worldName, mapState, teamAmount, minPlayers, maxPlayers, allowSpectating, spawnPoints);
        matchList.put(matchList.size(), match);
    }

    public static void addMatch(int id, String name, String worldName, MapState mapState, int teamAmount, int minPlayers, int maxPlayers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(id, name, worldName, mapState, teamAmount, minPlayers, maxPlayers, allowSpectating, spawnPoints);
        matchList.put(id, match);
    }*/

    public static void addMatch(String name, String worldName, int teamAmount, int minPlayers, int maxPlayers, int roundNumbers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(matchList.size(), name, worldName, teamAmount, minPlayers, maxPlayers, roundNumbers, allowSpectating, spawnPoints);
        matchList.put(matchList.size(), match);
    }

    public static void addMatch(int id, String name, String worldName, int teamAmount, int minPlayers, int maxPlayers, int roundNumbers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(id, name, worldName, teamAmount, minPlayers, maxPlayers, roundNumbers, allowSpectating, spawnPoints);
        matchList.put(id, match);
    }

    public static void addMatch(String name, String worldName, MapState mapState, int teamAmount, int minPlayers, int maxPlayers, int roundNumbers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(matchList.size(), name, worldName, mapState, teamAmount, minPlayers, maxPlayers, roundNumbers, allowSpectating, spawnPoints);
        matchList.put(matchList.size(), match);
    }

    public static void addMatch(int id, String name, String worldName, MapState mapState, int teamAmount, int minPlayers, int maxPlayers, int roundNumbers, boolean allowSpectating, SpawnPointList spawnPoints){
        MapManager.loadMap(worldName);

        //What other action should be here?

        Match match = new Match(id, name, worldName, mapState, teamAmount, minPlayers, maxPlayers, roundNumbers, allowSpectating, spawnPoints);
        matchList.put(id, match);
    }

    public static void disableMatch(int id){
        Match match = matchList.get(id);
        match.setState(MapState.DISABLED);

        matchList.replace(id, match);
    }

    public static void disableMatch(String name){
        Match match;
        for (int i = 0; i < matchList.size(); ++i){
            match = matchList.get(i);
            if (match.getName().equals(name)) {
                match.setState(MapState.DISABLED);
                matchList.replace(match.getId(), match);
            }
        }
    }

    public static void disableMatchMap(String worldName){
        Match match = null;
        for (int i = 0; i < matchList.size(); ++i){
            match = matchList.get(i);
            if (match.getWorldName().equals(worldName)) {
                break;
            }
        }

        if (match != null){
            match.setState(MapState.DISABLED);
            matchList.replace(match.getId(), match);
        }
    }

}
