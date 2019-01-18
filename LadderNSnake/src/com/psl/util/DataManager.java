package com.psl.util;

import java.util.Map;

import com.psl.beans.Obstacles;
import com.psl.beans.Player;

public interface DataManager {

	//static Map<Integer, Obstacles> board=null;
	
	public Map<Integer, Obstacles> Board();
	public Player Play( Map<Integer, Obstacles> board,Player player);
	public void Winner(Player player1,Player player2);
		
	
}
