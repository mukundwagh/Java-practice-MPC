package util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import sun.net.www.content.text.plain;

import Beans.Card;
import Beans.Deck;
import Beans.Player;
import Beans.Rank;
import Beans.Suite;

public class GameUtilityImpl implements GameUtility {

	// create a deck of cards
	public Deck getCardDeck() {

		Set<Card> deck = new HashSet<Card>();
		for (Suite suite : Suite.values()) {
			for (Rank rank : Rank.values()) {
				Card c = new Card(rank, suite);

				deck.add(c);

			}

		}

		// System.out.println(deck);
		Deck d = new Deck(deck);
		d.setCardDeck(deck);

		return d;
	}

	/*
	 * distribute cards to specified no of players and each player will have
	 * specified no of cards.
	 */
	public Map<Player, Set<Card>> distributeCards(Deck deck, int noOfPlayer,
			int noOfCards) {

		Map<Player, Set<Card>> map = new LinkedHashMap<Player, Set<Card>>();

		Deck temp = new Deck();
		temp = deck;
		Set<Card> tempC = new HashSet<Card>();
		tempC = temp.getCardDeck();

		System.out.println(tempC);

		int play = 1;
		for (Player player : Player.values()) {
			if (play > noOfPlayer) {
				break;
			}

			else {
				Set<Card> cardsV = new LinkedHashSet<Card>();
				int Dcard = 1;
				for (Iterator iterator = tempC.iterator(); iterator.hasNext();) {
					Card card = (Card) iterator.next();

					if (Dcard > noOfCards) {
						break;
					}

					else {
						cardsV.add(card);
						iterator.remove();
					}
					Dcard++;
				}

				map.put(player, cardsV);

			}
			play++;
		}

		return map;

	}

	/*
	 * find the score of each player by adding all rank values of cards which he
	 * has. and return a map containing score of each player.
	 */
	public Map<Player, Integer> playCards(Map<Player, Set<Card>> cardsMap) {

		Map<Player, Integer> score = new LinkedHashMap<Player, Integer>();

		for (Entry<Player, Set<Card>> entry : cardsMap.entrySet()) {

			Set<Card> tempc = new LinkedHashSet<Card>();
			tempc = entry.getValue();
			Integer sc = 0;
			for (Iterator iterator = tempc.iterator(); iterator.hasNext();) {
				Card card = (Card) iterator.next();

				sc = sc + card.getRank().getValue();
			}
			score.put(entry.getKey(), sc);

		}

		// System.out.println(score);
		return score;

	}

	/*
	 * find the player with highest score and declare him as a winner
	 */
	public Set<Player> declareWinner(Map<Player, Integer> result) {

		List<Integer> score = new ArrayList<Integer>();
		for (Entry<Player, Integer> entry : result.entrySet()) {

			score.add(entry.getValue());
		}

		Collections.sort(score, new sortw());
		Integer winner = score.get(0);
		Set<Player> win = new LinkedHashSet<Player>();
		for (Entry<Player, Integer> entry : result.entrySet()) {
			if (entry.getValue().equals(winner)) {
				win.add(entry.getKey());
			}

		}

		return win;

	}

	/*
	 * Arrenge all cards like : Card [rank=ACE, suite=SPADE] , Card [rank=ACE,
	 * suite=DIAMOND] , Card [rank=ACE, suite=CLUB] , Card [rank=ACE,
	 * suite=HEART] , Card [rank=DEUCE, suite=SPADE] , Card [rank=DEUCE,
	 * suite=DIAMOND] , Card [rank=DEUCE, suite=CLUB] , Card [rank=DEUCE,
	 * suite=HEART]
	 */
	public Set<Card> arrangeCards(Set<Card> cards) {

		Set<Card> deck = new LinkedHashSet<Card>();
		for (Rank rank : Rank.values()) {
			for (Suite suite : Suite.values()) {

				Card c = new Card(rank, suite);

				deck.add(c);

			}

		}

		System.out.println(deck);
		return deck;

	}

	public Map<Player, Set<Card>>  sortMap(Map<Player, Set<Card>> map) {
		for (Entry<Player, Set<Card>> entry : map.entrySet()) {
			Set<Card> set = new TreeSet<Card>(new sortOrder());
			set.addAll(entry.getValue());
			map.put(entry.getKey(), set);
		}
		//System.out.println(map);
		return map;

	}
	public Set<Player> straightFlush(Map<Player, Set<Card>> map) {
		
		map=sortMap(map);
		System.out.println(map);
		Set<Player> win = new LinkedHashSet<Player>();
		
		for(Entry<Player, Set<Card>> entry : map.entrySet())
		{
			
			Set<Card> temps = new TreeSet<Card>();
			temps=entry.getValue();
			Iterator<Card> iterator = temps.iterator();
			
			int i=iterator.next().getRank().getValue();
			boolean flag = true ;
			while (iterator.hasNext()) {
				Card card = (Card) iterator.next();
				i++;
				if(i!=card.getRank().getValue())
				{
					flag = false;
					break;
				}
				
				
			}
			if(flag==true)
			{
				win.add(entry.getKey());
			}
			
		}
		System.out.println(win);
		
		if(win.isEmpty())
		{

			for(Entry<Player, Set<Card>> entry : map.entrySet())
			{
				
				Set<Card> temps = new TreeSet<Card>();
				temps=entry.getValue();	
				Iterator<Card> iterator = temps.iterator();
				boolean flag = true;
				Suite s = iterator.next().getSuite();
				
				while (iterator.hasNext()) {
					Card card = (Card) iterator.next();
					
					if(!card.getSuite().equals(s))
					{
						flag =false;
						break;
					}
					
					if(flag ==true){
						win.add(entry.getKey());
					}
				}
			}
		}
		
		System.out.println(win);
		
		return win;

	}

}
