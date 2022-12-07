package main.java.es.unex.cum.pcd.practicafinal.app;

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
                Thread.sleep(700);
            } catch (InterruptedException e1) {

            }
        }
    }
}
