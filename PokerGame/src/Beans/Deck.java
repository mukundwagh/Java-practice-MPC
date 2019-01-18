package Beans;

import java.util.Set;

public class Deck {
     private Set<Card> cardDeck;
     
     public Deck(Set<Card> cardDeck) {
		super();
		this.cardDeck = cardDeck;
	}

	public Set<Card> getCardDeck() {
		
		
		return cardDeck;
	}

	public void setCardDeck(Set<Card> cardDeck){
    	 this.cardDeck = cardDeck;
    	 
     }

	public Deck() {
		super();
	
	}

	@Override
	public String toString() {
		return "Deck [cardDeck=" + cardDeck + "]"+"\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((cardDeck == null) ? 0 : cardDeck.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Deck))
			return false;
		Deck other = (Deck) obj;
		if (cardDeck == null) {
			if (other.cardDeck != null)
				return false;
		} else if (!cardDeck.equals(other.cardDeck))
			return false;
		return true;
	}
     
}
