package main.java.es.unex.cum.pcd.practica6Monitores;

public class PlayerOut implements Runnable {

    private Game game;

    PlayerOut(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            try {
                game.removePlayer();
                Thread.sleep(1000);
            } catch (InterruptedException | EmptyGameException e) {
            }
        }
    }
}

