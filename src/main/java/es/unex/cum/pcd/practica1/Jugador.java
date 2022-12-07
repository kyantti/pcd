package main.java.es.unex.cum.pcd.practica1;

/**
 * Jugador
 */

public class Jugador {
    private String nombre;
    private int puntuacion;
    private int id;
    private int fichas;
    
    public Jugador(String nombre, int puntuacion, int id, int fichas) {
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.id = id;
        this.fichas = fichas;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getFichas() {
        return fichas;
    }
    public void setFichas(int fichas) {
        this.fichas = fichas;
    }
    
    
}