package main.java.es.unex.cum.pcd.practicafinal.app;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Game {
    private Board board;
    private List <Player> players;
    private int maxPlayers;
    private int currentPlayers;
    private Lock lock;  //para la exclusion mutua
    private Lock lock2;
    private Condition full; //varibale de condicion
    private Condition empty; //varibale de condicion
    private Condition unoccupied;
    private Condition occupied;
    private Random rand;

    public Game(int rows, int columns, int maxPlayers) throws NoSuchAlgorithmException {
		board = new Board(rows, columns);
        players = new LinkedList<>();
        this.maxPlayers = maxPlayers;
        currentPlayers = players.size();
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition(); 
        lock2 = new ReentrantLock();
        unoccupied = lock2.newCondition();
        occupied = lock2.newCondition();
        rand = SecureRandom.getInstanceStrong();
        
	}

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
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
        Player player = new Player(players.size());

        lock.lock();

        try {
            while (currentPlayers == maxPlayers) {
                full.await();
            }
            //sc
            players.add(player);
            System.out.print("Jugador " + player.getId() + " entra en la partida...");
            currentPlayers = currentPlayers + 1;
            System.out.print("OK\n");
            //señalo variable condicion
            empty.signal();
            
        } 
        finally{
            lock.unlock();
        }
    }

    public void removePlayer() throws InterruptedException {
        Player player = players.get(rand.nextInt(players.size()));

        lock.lock();
        try {
            while (currentPlayers == 0) {
                empty.await();
            }
            //sc
            players.remove(player);
            System.out.print("Jugador " + player.getId() + " abandona la partida...");
            currentPlayers --;
            System.err.print("OK\n");
            full.signal();
        }
        finally{
            lock.unlock();
        }

    }

    public void play() throws InterruptedException{
        
        Player player = players.get(rand.nextInt(currentPlayers));
        Box box = board.getBoxes()[rand.nextInt(board.rows())][rand.nextInt(board.columns())];

        lock2.lock();
        try {
            while (Boolean.TRUE.equals(box.getOccupied() || player.isNextTurnSkipped())) {
                occupied.await();
            }
            //CRITICAL SECTION
            box.setOccupied(true);
            box.setPlayerId(player.getId());
            player.setTokens(player.getTokens() - 1);
            int pointsEarned = 0;
            switch (box.getType()) {
                case 0:
                pointsEarned = rand.nextInt(100);
                player.setScore(player.getScore() + pointsEarned);
                System.out.println("El juugador " + player.getId() + " ha gando +" + pointsEarned + "puntos" );
                    break;
                case 1:
                pointsEarned = rand.nextInt(4);
                player.setScore(player.getScore() * pointsEarned);
                System.out.println("El juugador " + player.getId() + " ha recivido un BOOST de x" + pointsEarned + "puntos" );
                    break;
                case 2:
                player.setNextTurnSkipped(true);
                System.out.println("El jugador " + player.getId() + " pierde el siguiente turno");
                    break;
                default:
                    break;
            }
            if (player.isNextTurnSkipped()) {
                player.setNextTurnSkipped(false);
            }
            unoccupied.signal();
            
        }
        finally{
            lock2.unlock();
        }

    }

    public boolean gameEnded(){
        boolean fin=false;
        if (currentPlayers == 0) {
            System.out.println("No quedan jugadores, fin del juego");
            fin=!fin;
        }
        return fin;
    }

    public void countPlayers(){
        lock.lock();
        //sc
        System.out.println("Numero de jugadores actual: " + currentPlayers);
        //sc
        lock.unlock();
    }

}