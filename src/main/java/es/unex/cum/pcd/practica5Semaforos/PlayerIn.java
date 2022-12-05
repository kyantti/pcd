package es.unex.cum.pcd.practica5Semaforos;

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

            }
        }
    }
}
