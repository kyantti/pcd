package main.java.es.unex.cum.pcd.semaforos.practicasemaforos5;


public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game(10, 10, 10, 50);

        System.out.println("Numero inicial de jugadores: " + game.getPlayerList().size());

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
