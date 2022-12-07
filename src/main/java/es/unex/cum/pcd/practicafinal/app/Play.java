package main.java.es.unex.cum.pcd.practicafinal.app;

public class Play implements Runnable {
    private Game game;

    Play(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            try {
                game.play();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                
            }
        }
    }
}
