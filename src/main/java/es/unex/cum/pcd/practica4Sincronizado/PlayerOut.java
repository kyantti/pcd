package es.unex.cum.pcd.practica4Sincronizado;
public class PlayerOut implements Runnable {

    private Game game;

    PlayerOut(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        while (true) {
            game.removePlayer();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}

