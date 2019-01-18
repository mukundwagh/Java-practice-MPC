package com.psl.main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.psl.bean.Catering;
import com.psl.bean.CateringType;
import com.psl.bean.ColdDrinks;
import com.psl.bean.Event;
import com.psl.bean.EventTime;
import com.psl.bean.IceCream;
import com.psl.utils.EventUtilImpl;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventUtilImpl impl = new EventUtilImpl();
		
		List<Event> events = new ArrayList<Event>();
		events=impl.populateEvent("Events");
		System.out.println(events);
		
		ColdDrinks cd = ColdDrinks.Coke;
		IceCream ic=IceCream.Choclate;
		CateringType ct= CateringType.ShahiThat;
		Event e = events.get(1);
		
		Catering catering =impl.findCateringCost(cd, ic, ct, e );
		System.out.println(catering.toString());
		
		
	long cost =impl.totalEventEstimatecost(catering, e);
		System.out.println(cost);
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		Date startdate1;
		try {
			List<Event> dateslist = new ArrayList<Event>();
			startdate1 = dateFormat.parse("2015/03/15");

			Date enddate2=dateFormat.parse("2015/05/12");
			dateslist=impl.getEventsBetweenDates(startdate1, enddate2, events);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Map<EventTime, List<Event>> map =new HashMap<EventTime, List<Event>>();
		map=impl.getMapByEventTime(events);
		System.out.println(map);
		
	}

}
