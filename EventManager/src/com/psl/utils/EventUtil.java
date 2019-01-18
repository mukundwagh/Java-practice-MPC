package com.psl.utils;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.psl.bean.Catering;
import com.psl.bean.CateringType;
import com.psl.bean.ColdDrinks;
import com.psl.bean.Event;
import com.psl.bean.EventTime;
import com.psl.bean.IceCream;

public interface EventUtil {
	List<Event> populateEvent(String fileName);
	Catering findCateringCost(ColdDrinks cd,IceCream ic,CateringType ct,Event e );
	long totalEventEstimatecost(Catering c,Event event);
	List<Event> getEventsBetweenDates(Date startdate1,Date enddate2,List<Event> events);
	Map<EventTime,List<Event>> getMapByEventTime(List<Event> events);
}
