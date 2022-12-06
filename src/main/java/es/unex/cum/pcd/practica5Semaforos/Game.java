package main.java.es.unex.cum.pcd.practica5semaforos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;


public class Game {
    private Board gameBoard;
    private List <Player> playerList;
    private int token;
    private int maxPlayers;
    private int currentPlayers;

    //para la sc
    private Semaphore mutex;
    //para ver si el jugo esta vcio
    private Semaphore empty;
    //para ver si el juego ta lleno
    private Semaphore full;

    public Game(int token, int nRows, int nColumns, int maxPlayers) {
        gameBoard = new Board(nRows, nColumns);
        playerList = new ArrayList<>();
        this.token = token;
        this.maxPlayers = maxPlayers;

        mutex = new Semaphore(1);
        empty = new Semaphore(0);
        full = new Semaphore(maxPlayers);
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

    public void addPlayer() throws InterruptedException{
        Player player = new Player(null, 0, currentPlayers + 1, 0);
        full.acquire();
        mutex.acquire();
        //sc
        playerList.add(player);
        System.out.print("Jugador " + player.getPlayerId() + " entra en la partida...");
        currentPlayers = currentPlayers + 1;
        System.out.print("OK\n");
        //sc
        mutex.release();
        empty.release();
    }

    public void removePlayer() throws InterruptedException {
        Player player = playerList.get(new Random().nextInt(currentPlayers));

        empty.acquire();
        mutex.acquire();
        //sc
        playerList.remove(player);
        System.out.print("Jugador " + player.getPlayerId() + " abandona la partida...");
        currentPlayers --;
        System.err.print("OK\n");
        //sc
        
        mutex.release();
        full.release();

    }

    public boolean gameEnded(){
        boolean fin=false;
        if (currentPlayers == 0) {
            System.out.println("No quedan jugadores, fin del juego");
            fin=!fin;
        }
        return fin;
    }

    public void initializePlayers(){
        for (int i = 0; i < 10; i++) {
            playerList.add(new Player(null, 0, new Random().nextInt(10), 0));
        }
    }

    public void countPlayers() throws InterruptedException{
        mutex.acquire();
        //sc
        System.out.println("Numero de jugadores actual: " + currentPlayers);
        //sc
        mutex.release();
    }

}