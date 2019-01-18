package util;

import java.util.Map;
import java.util.Set;

import Beans.Card;
import Beans.Deck;
import Beans.Player;

public interface GameUtility {
	Set<Card> arrangeCards(Set<Card> cards);
    Deck getCardDeck();
    Map<Player,Set<Card>> distributeCards(Deck deck,int noOfPlayer,int noOfCards);
    Map<Player,Integer> playCards(Map<Player,Set<Card>> cardsMap);
    Set<Player> declareWinner(Map<Player,Integer> result);
}
