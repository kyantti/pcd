package es.unex.cum.pcd.practica4Sincronizado;

public class CountPlayers extends Thread {
    private Game game;

    CountPlayers(Game game){
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    @Override
    public void run() {
       while (true) {
        game.countPlayers();
        try {
            Thread.sleep(700);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
       }
    }

    
}
