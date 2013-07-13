package com.appathon.letsgo;

import java.util.ArrayList;
import java.util.Date;

import android.text.format.Time;

public class Event {
	
	private int ID;
	private Time StartTime;
	private Date date;
	private ArrayList<User> Attendees;
	
	public Event(int id, Time start, Date day)
	{
		ID = id;
		StartTime = start;
		date = day;
		Attendees = new ArrayList<User>();
	}
	
	boolean addAttendee(User attendee)
	{
		return Attendees.add(attendee);
	}
	
	boolean setTime(Time time)
	{
		StartTime = time;
		return true;
	}
	
	boolean setDate(Date day)
	{
		date = day;
		return true;
	}
	
	int getID()
	{
		return ID;
	}
	
	Time getTime()
	{
		return StartTime;
	}
}
