package main.java.es.unex.cum.pcd.practicafinal.app;

import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) throws NoSuchAlgorithmException, InterruptedException {
        
        Game game = new Game(5, 5, 5);

        System.out.println("Numero inicial de jugadores: " + game.getPlayers().size());

        PlayerIn playerInThread = new PlayerIn(game);
        PlayerOut playerOutThread = new PlayerOut(game);
        CountPlayers countPlayerThread = new CountPlayers(game);
        Play play = new Play(game);

        Thread in = new Thread(playerInThread);
        Thread out = new Thread(playerOutThread);
        Thread playThread = new Thread(play);
        

        in.start();
        playThread.start();
        out.start();
        countPlayerThread.start();
    }
}
