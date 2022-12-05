package main.java.es.unex.cum.pcd.practica6Monitores;

import java.util.ArrayList;
import java.util.List;

/**
 * Jugador
 */

public class Player {
    
    private String nick;
    private int score;
    private int id;
    private List<Token> tokens;

	public Player(String nick, int score, int id) {
		this.nick = nick;
		this.score = score;
		this.id = id;
		tokens = new ArrayList<Token>();
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Token> getTokens() {
		return tokens;
	}

	public void setTokens(List<Token> tokens) {
		this.tokens = tokens;
	}    
   
}