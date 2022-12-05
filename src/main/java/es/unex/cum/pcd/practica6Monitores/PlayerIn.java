package main.java.es.unex.cum.pcd.practica6Monitores;

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
            } catch (InterruptedException | FullGameException e) {
                
            }
        }
    }
}
