package zkyubz.huskimc.core.game.variables;

import java.util.HashMap;

public class SpawnPointList {
    private HashMap<Integer, SpawnPoint> spawnPointList = new HashMap<>();

    public SpawnPointList(){}

    public SpawnPoint getSpawnPoint(int id){
        return spawnPointList.get(id);
    }

    public void add(int id, SpawnPoint spawnPoint){
        spawnPointList.put(id, spawnPoint);
    }
}
