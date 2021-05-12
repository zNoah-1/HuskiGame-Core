package zkyubz.huskimc.core.game.variables;

public class SpawnPoint {
    int x;
    int y;
    int z;
    int yaw;
    int pitch;

    public SpawnPoint (int x, int y, int z, int yaw, int pitch){
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getZ(){
        return this.z;
    }

    public int getPitch(){
        return pitch;
    }

    public int getYaw(){
        return yaw;
    }

    public void setCoordinate(int x, int y, int z, int pitch, int yaw){
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
    }

}
