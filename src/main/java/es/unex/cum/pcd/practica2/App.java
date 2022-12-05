package es.unex.cum.pcd.practica2;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game(10, 10, 10, 3);
        System.out.println("Numero inicial de jugadores: " + game.getPlayerList().size());
        System.out.println("Numero de jugadores actual: " + game.getCurrentPlayers());
        System.out.println("Numero maximo de jugadores: "+ game.getMaxPlayers());

        try {
            game.removePlayer(new Player("Pedro", 0, 'A', 0));
        } catch (EmptyGameException e) {
            System.out.println(e.getMessage());
        }

        try {
            game.addPlayer(new Player("Pedro", 0, 'A', 0));
            game.addPlayer(new Player("Juan", 0, 'B', 0));
            game.addPlayer(new Player("Marta", 0, 'C', 0));
            game.addPlayer(new Player("Maria", 0, 'D', 0));
        } catch (FullGameException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Numero de jugadores actual: " + game.getCurrentPlayers());
        System.out.println("Numero maximo de jugadores: "+ game.getMaxPlayers());

        try {
            game.addPlayer(new Player("Nuria", 0, 'D', 0));
            game.addPlayer(new Player("Nuria", 0, 'E', 0));
        } catch (FullGameException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Numero de jugadores actual: " + game.getCurrentPlayers());
        System.out.println("Numero maximo de jugadores: "+ game.getMaxPlayers());

        try {
            game.addPlayer(new Player("Jorge", 0, 'F', 0));
        } catch (FullGameException e) {
            System.out.println(e.getMessage());
        }
        try {
            game.removePlayer(new Player("Maria", 0, 'D', 0));
            game.removePlayer(new Player("Marta", 0, 'C', 0));
        } catch (EmptyGameException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Numero de jugadores actual: " + game.getCurrentPlayers());
        System.out.println("Numero maximo de jugadores: "+ game.getMaxPlayers());

        try {
            game.addPlayer(new Player("Jorge", 0, 'F', 0));
        } catch (FullGameException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Numero de jugadores actual: " + game.getCurrentPlayers());
        System.out.println("Numero maximo de jugadores: "+ game.getMaxPlayers());

    }
}
