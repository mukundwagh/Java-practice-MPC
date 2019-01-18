package com.psl.utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.psl.bean.Catering;
import com.psl.bean.CateringType;
import com.psl.bean.ColdDrinks;
import com.psl.bean.Event;
import com.psl.bean.EventTime;
import com.psl.bean.EventType;
import com.psl.bean.IceCream;
import com.psl.bean.Person;

public class EventUtilImpl implements EventUtil {

	@Override
	public List<Event> populateEvent(String fileName) {
		// TODO Auto-generated method stub
		
		List<Event> events = new ArrayList<Event>();
		try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader reader = new BufferedReader(fileReader);
			
			String line;
			String [] data;
			
			while((line=reader.readLine())!= null){
				
				if(line.contentEquals("")){
					continue;
				}
				data=line.split(",");
				DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
				//System.out.println(date);
				
				
				
				int eventID=0;
				String eventOwner=null;
				EventType eventType=null;
				Date eventDate=null;
				EventTime eventTime=null;
				int noOfChild=0;
				int noOfAdults=0;
					
				if(!(data[0].contentEquals(""))){	
				eventID=Integer.parseInt(data[0]);
				}
				
				if(!(data[1]=="")){
				eventOwner=data[1].toString();
				}
				
				if(!(data[2].contentEquals(""))){
				eventType=EventType.valueOf(data[2]);
				}
				if(!(data[3].contentEquals("")))
				{

					Date date= df.parse(data[3]);
						 eventDate=date;
						
				}
				if(!(data[4].contentEquals(""))){
				eventTime=EventTime.valueOf(data[4]);}
				
				if(!(data[5].contentEquals(""))){
			 noOfChild=Integer.parseInt(data[5]);
				}
			if(!(data[6].contentEquals(""))){
			
				noOfAdults=Integer.parseInt(data[6]);
			}	
			
				
				
				Event event2 = new Event(eventID, eventOwner, eventType, eventDate, eventTime, noOfChild, noOfAdults);
				events.add(event2);
				}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return events;
	}

	@Override
	public Catering findCateringCost(ColdDrinks cd, IceCream ic,
			CateringType ct, Event e) {
		// TODO Auto-generated method stub
		
		Catering catering = new Catering();
		catering.setCateringCost(cd.getColdDrinkCost()+ic.getIceCreamCost()+ct.getPerPlateCost()+e.getEventType().getEventTypeCost()+e.getEventTime().getEventTimeCost());
		//System.out.println(catering.getCateringCost());
		
		return catering;
	}

	@Override
	public long totalEventEstimatecost(Catering c, Event event) {
		// TODO Auto-generated method stub
		
		int adults = event.getNoOfAdults();
		int child = event.getNoOfChild();
		
		int adultscost = Person.Adult.getPerPersonCost();
		int childcost = Person.Child.getPerPersonCost();
		
		c.setCateringCost((childcost*child) +(adults*adultscost)+event.getEventTime().getEventTimeCost()+event.getEventType().getEventTypeCost());
		
		
		return c.getCateringCost();
	}

	@Override
	public List<Event> getEventsBetweenDates(Date startdate1, Date enddate2,
			List<Event> events) {
		// TODO Auto-generated method stub
		
		List<Event> dateslist = new ArrayList<Event>();
		for (Iterator iterator = events.iterator(); iterator.hasNext();) {
			Event event = (Event) iterator.next();
			
			if(event.getEventDate().before(enddate2)&&event.getEventDate().after(startdate1)){
				dateslist.add(event);
			}
		}
		//System.out.println(dateslist);
		return dateslist;
	}

	@Override
	public Map<EventTime, List<Event>> getMapByEventTime(List<Event> events) {
		// TODO Auto-generated method stub
		
		List<Event> lateNight = new ArrayList<Event>();
		List<Event> day = new ArrayList<Event>();
		
		for (Iterator iterator = events.iterator(); iterator.hasNext();) {
			Event event = (Event) iterator.next();
			
			if(event.getEventTime().equals(EventTime.Day)){
				day.add(event);
			}
			else{
				lateNight.add(event);
			}
				
		}
		Map<EventTime, List<Event>> map = new HashMap<EventTime, List<Event>>();
		map.put(EventTime.Day, day);
		map.put(EventTime.LateNight, lateNight);
		return map;
	}

}
