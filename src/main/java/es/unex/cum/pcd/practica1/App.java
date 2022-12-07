package main.java.es.unex.cum.pcd.practica1;


public class App {
    public static void main(String[] args) throws Exception {
        int fichas=10;
        int fil = 10;
        int col = 10;
        Juego juego = new Juego(fichas, fil, col, 15);
        for (int i = 0; i < 20; i++) {
            try {
                juego.jugadorEntra(new Jugador(null, i, i, 5));
            } catch (Exception e) {

            }
           
        }
        for (int i = 0; i < 30; i++) {
            try {
                //juego.jugadorSale();
            } catch (Exception e) {
            
            }
        }
    }
}
