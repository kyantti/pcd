package es.unex.cum.pcd.practica3;

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
            try {
                game.countPlayers();
                sleep(750);
            } catch (Exception e) {

            }
        }
    }

    
}
