package main.java.es.unex.cum.pcd.practica3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Juego
 */

public class Game {
    private Board gameBoard;
    private List <Player> playerList;
    private int token;
    private int maxPlayers;
    private int currentPlayers;

    public Game(int token, int nRows, int nColumns, int maxPlayers) {
        gameBoard = new Board(nRows, nColumns);
        playerList = new ArrayList<>();
        this.token = token;
        this.maxPlayers = maxPlayers;
    }

    public Board getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(Board gameBoard) {
        this.gameBoard = gameBoard;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public void setPlayerList(List<Player> playerList) {
        this.playerList = playerList;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(int maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public int getCurrentPlayers() {
        return currentPlayers;
    }

    public void setCurrentPlayers(int currentPlayers) {
        this.currentPlayers = currentPlayers;
    }

    public void addPlayer(Player player) throws FullGame {
        if (currentPlayers == maxPlayers) {
            throw new FullGame();
        }
        playerList.add(player);
        System.out.println("Jugador " + player.getPlayerId() + " entra en la partida");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        currentPlayers ++;

    }

    public void removePlayer(Player player) throws EmptyGame{
        if (currentPlayers == 0) {
            throw new EmptyGame();
        }
        playerList.remove(player);
        currentPlayers --;
        System.out.println("Jugador " + player.getPlayerId() + " abandona la partida");
    }

    public boolean gameEnded(){
        boolean end=false;
        if (currentPlayers == 0) {
            System.out.println("No quedan jugadores, fin del juego");
            end=!end;
        }
        return end;
    }

    public void initializePlayers(){
        for (int i = 0; i < 10; i++) {
            playerList.add(new Player(null, 0, new Random().nextInt(10), 0));
        }
    }

    public void countPlayers(){
        System.out.println("Numero de jugadores actual: " + currentPlayers);
    }

}