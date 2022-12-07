package main.java.es.unex.cum.pcd.practicafinal.app;

import org.junit.platform.console.options.Theme;

public class PlayerIn implements Runnable{

    private Game game;

    PlayerIn(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            try {
                game.addPlayer();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
