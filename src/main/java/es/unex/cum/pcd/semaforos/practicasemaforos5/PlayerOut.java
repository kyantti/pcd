package main.java.es.unex.cum.pcd.semaforos.practicasemaforos5;
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
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

