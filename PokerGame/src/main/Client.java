package main;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import Beans.Card;
import Beans.Deck;
import Beans.Player;
import util.GameUtilityImpl;

public final class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		GameUtilityImpl dimp = new GameUtilityImpl();
		Deck deck=dimp.getCardDeck();
		
		Map<Player, Set<Card>> map = new LinkedHashMap<Player, Set<Card>>();
		map=dimp.distributeCards(deck, 2, 3);
		System.out.println(map);
		
		Map<Player, Integer> playC = new LinkedHashMap<Player, Integer>();
		playC=dimp.playCards(map);
		System.out.println(playC);
		
		Set<Player> win= new LinkedHashSet<Player>();
		win=dimp.declareWinner(playC);
		System.out.println(win);
		Set<Card> cards = new LinkedHashSet<Card>();
		dimp.arrangeCards(cards);
		
		dimp.straightFlush(map);
	}

}
