package main.java.es.unex.cum.pcd.practica3;

/**
 * Jugador
 */

public class Player {
    
    private String playerName;
    private int score;
    private int playerId;
    private int tokens;

    public Player(String playerName, int score, int playerId, int tokens) {
        this.playerName = playerName;
        this.score = score;
        this.playerId = playerId;
        this.tokens = tokens;
    }
    
    public String getPlayerName() {
        return playerName;
    }
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getPlayerId() {
        return playerId;
    }
    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
    public int getTokens() {
        return tokens;
    }
    public void setTokens(int tokens) {
        this.tokens = tokens;
    }
    
}