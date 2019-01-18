package com.Client;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Map;

import com.psl.beans.Obstacles;
import com.psl.beans.Player;
import com.psl.util.Game;

public class Client {


	/**
	 * @param args
	 * @return
	 */

	public static Map<Integer, Obstacles> board;

	public static void main(String[] args) {
	 

		
		
		
		Game game = new Game();
		board = game.Board();
		System.out.println(board);

		Player player1 = new Player();
		Player player2 = new Player();

		while ((player1.getLocation() < 100) && (player2.getLocation() < 100)) {
			game.Play(board, player1);

			game.Play(board, player2);
			System.out.println("1" + player1);
			System.out.println("2" + player2);
		}

		game.Winner(player1, player2);

	}

}
