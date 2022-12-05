package main.java.es.unex.cum.pcd.practica6Monitores;


public class App {
    public static void main(String[] args) throws Exception {
        F
        List<Player> players = new Ar
        Game game = new Game(0, 0, 0, null);

        System.out.println("Numero inicial de jugadores: " + game.getPlayers().size());

        PlayerIn playerInThread = new PlayerIn(game);
        PlayerOut playerOutThread = new PlayerOut(game);
        CountPlayers countPlayerThread = new CountPlayers(game);

        Thread in = new Thread(playerInThread);
        Thread out = new Thread(playerOutThread);
        Thread count = new Thread(countPlayerThread);

        in.start();
        out.start();
        count.start();
    }
}
