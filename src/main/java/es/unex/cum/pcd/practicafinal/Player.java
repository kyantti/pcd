package main.java.es.unex.cum.pcd.practicafinal;

import java.util.ArrayList;
import java.util.List;

/**
 * Jugador
 */

public class Player {
    private int score;
    private int id;
    private int tokens;
	private boolean nextTurnSkipped;

	public Player(int id) {
		this.id = id;
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

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public boolean isNextTurnSkipped() {
		return nextTurnSkipped;
	}

	public void setNextTurnSkipped(boolean nextTurnSkipped) {
		this.nextTurnSkipped = nextTurnSkipped;
	}
	
}