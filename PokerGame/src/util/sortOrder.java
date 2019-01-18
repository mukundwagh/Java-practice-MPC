package util;

import java.util.Comparator;

import Beans.Card;

public class sortOrder implements Comparator<Card> {

	@Override
	public int compare(Card arg0, Card arg1) {
		// TODO Auto-generated method stub
		
		int i =arg0.getRank().compareTo(arg1.getRank());
		if(i==0)
		{
		int j=	arg0.getSuite().compareTo(arg1.getSuite());
			
			return j;
		}
		
		return(i);
	}

}
