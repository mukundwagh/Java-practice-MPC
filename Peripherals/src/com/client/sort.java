package com.client;

import java.util.Comparator;

import com.beans.Peripheral;

public class sort implements Comparator<Peripheral> {

	@Override
	public int compare(Peripheral arg0, Peripheral arg1) {
		// TODO Auto-generated method stub
		
		if(arg0.getPrice()<arg1.getPrice())
		{
			return -1;
		}
		else if (arg0.getPrice()>arg1.getPrice()) {
			return 1;
			
		}
		else
		return 0;
	}

}
