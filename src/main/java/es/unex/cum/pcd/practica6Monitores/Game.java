package main.java.es.unex.cum.pcd.practica6Monitores;

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
    private Condition full; //varibale de condicion
    private Condition empty; //varibale de condicion
    private Condition unoccupied;
    private Condition occupied;

    public Game(int rows, int columns, int maxPlayers, List<Player> players) {
		board = new Board(rows, columns);
        this.players = players;
        this.maxPlayers = maxPlayers;
        currentPlayers = players.size();
        lock = new ReentrantLock();
        full = lock.newCondition();
        empty = lock.newCondition(); 
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

    public void addPlayer() throws FullGameException, InterruptedException{
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

    public void removePlayer() throws EmptyGameException, InterruptedException {
        Player player = players.get(new Random().nextInt(currentPlayers));

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
        Player player = players.get(new Random().nextInt(currentPlayers));
        Box box = board.getBoxes()[new Random().nextInt(board.rows())][new Random().nextInt(board.columns())];

        lock.lock();
        try {
            while (Boolean.TRUE.equals(box.getOccupied())) {
                occupied.await();
            }
            //sc
            box.setOccupied(true);
            box.setPlayerId(player.getId());
            player.setTokens(player.getTokens() - 1);
            switch (box.getType()) {
                case 0:
                player.setScore(player.getScore() + new Random().nextInt(100));
                    break;
                case 1:
                player.setScore(player.getScore() * new Random().nextInt(4));
                    break;
                case 2:
                
                    break;
                default:
                    break;
            }
            
        }
        finally{
            lock.unlock();
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

    public void countPlayers() throws InterruptedException{
        lock.lock();
        //sc
        System.out.println("Numero de jugadores actual: " + currentPlayers);
        //sc
        lock.unlock();
    }

}