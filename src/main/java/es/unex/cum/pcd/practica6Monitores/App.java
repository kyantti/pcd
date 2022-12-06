package main.java.es.unex.cum.pcd.practica6monitores;

import java.util.LinkedList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Player> players = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            players.add(new Player(players.size()));
        }
        Game game = new Game(0, 0, 10, players);

        System.out.println("Numero inicial de jugadores: " + game.getPlayers().size());

        PlayerIn playerInThread = new PlayerIn(game);
        PlayerOut playerOutThread = new PlayerOut(game);
        CountPlayers countPlayerThread = new CountPlayers(game);

        Thread in = new Thread(playerInThread);
        Thread out = new Thread(playerOutThread);
        

        in.start();
        out.start();
        countPlayerThread.start();
    }
}
