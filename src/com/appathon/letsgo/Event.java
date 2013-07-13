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
	
	public boolean addAttendee(User attendee)
	{
		return Attendees.add(attendee);
	}
	
	public boolean setTime(Time time)
	{
		StartTime = time;
		return true;
	}
	
	public boolean setDate(Date day)
	{
		date = day;
		return true;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public Time getTime()
	{
		return StartTime;
	}
	
	public Date getDate()
	{
		return date;
	}
	
	public ArrayList<User> getAttendees()
	{
		return Attendees;
	}
}
