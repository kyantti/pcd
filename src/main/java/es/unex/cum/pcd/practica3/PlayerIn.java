package es.unex.cum.pcd.practica3;

public class PlayerIn implements Runnable{

    private Game game;

    PlayerIn(Game game){
        this.game = game;
    }

    @Override
    public void run() {
        Player player = new Player(null, 0, game.getCurrentPlayers() + 1, 0);
        while (true) {
            try {
                game.addPlayer(player);
            } catch (FullGame e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
    }
    
}
