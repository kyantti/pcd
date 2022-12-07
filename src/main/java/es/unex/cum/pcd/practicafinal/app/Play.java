package main.java.es.unex.cum.pcd.practicafinal.app;

public class Play extends Thread {
    private Game game;

    Play(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            try {
                game.play();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    
}
