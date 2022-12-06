package main.java.es.unex.cum.pcd.practicafinal;

public class Box {
    
    private Boolean occupied;
    private int type;
    private int playerId;

    public Box(){
        
    }

    public Box(Boolean occupied, int type, int playerId) {
        this.occupied = occupied;
        this.type = type;
        this.playerId = playerId;
    }

    public Boolean getOccupied() {
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