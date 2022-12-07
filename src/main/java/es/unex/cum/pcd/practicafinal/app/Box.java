package main.java.es.unex.cum.pcd.practicafinal.app;

public class Box {
    
    private boolean occupied;
    private int type;
    private int playerId;

    public Box(){
        occupied = false;
        type = 0;
        playerId = 0;
    }

    public Box(boolean occupied, int type, int playerId) {
        this.occupied = occupied;
        this.type = type;
        this.playerId = playerId;
    }

    public boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean occupied) {
        this.occupied = occupied;
    }

    public void setType(int type){
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

}