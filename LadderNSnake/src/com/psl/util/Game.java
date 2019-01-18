package com.psl.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

import com.psl.beans.Obstacles;
import com.psl.beans.Player;

public class Game implements DataManager {

	@Override
	public Map<Integer, Obstacles> Board() {
		// TODO Auto-generated method stub

		Map<Integer, Obstacles> map = new LinkedHashMap<Integer, Obstacles>();

		for (int i = 1; i < 101; i++) {

			map.put(i, null);
		}

		try {
			FileReader fileReader = new FileReader("Ladder.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			String[] data;
			while ((line = bufferedReader.readLine()) != null) {
				data = line.split("-");
				Obstacles obstacles = new Obstacles(Integer.parseInt(data[0]),
						Integer.parseInt(data[1]));

				map.put(obstacles.getOldValue(), obstacles);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			FileReader reader = new FileReader("Snake.txt");
			BufferedReader reader2 = new BufferedReader(reader);
			String line1;
			String[] data1;

			while ((line1 = reader2.readLine()) != null) {
				data1 = line1.split("-");
				Obstacles obstacles = new Obstacles(Integer.parseInt(data1[0]),
						Integer.parseInt(data1[1]));
				map.put(obstacles.getOldValue(), obstacles);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(map);

		return map;
	}

	@Override
	public Player Play(Map<Integer, Obstacles> board, Player player) {
		// TODO Auto-generated method stub

		Random random = new Random();
		Integer start = 1;
		Integer end = 6;
		Integer n = (end - start) + 1;
		Integer Dice = random.nextInt(6) % n;
		Dice = start + Dice;
		Integer oldValue=player.getLocation();
		player.setLocation(player.getLocation() + Dice);

		Obstacles obstacles = board.get(player.getLocation());
		if (obstacles!=null) {
			player.setLocation(obstacles.getNewValue());
		}
		
		if(player.getLocation()>100){
			
			player.setLocation(oldValue);
		}
		

		return player;
	}

	@Override
	public void Winner(Player player1, Player player2) {
		// TODO Auto-generated method stub
		
		if(player1.getLocation()==100){
			
			System.out.println("Player 1");
			
		}
		else {
			System.out.println("Player 2");
				
		}
		
	}

}
