package com.appathon.letsgo;

import java.util.ArrayList;
import java.util.Date;

import android.text.format.Time;

/*
 * Event object.
 */

public class Event {
	
	private int ID;
	private Date StartTime;
	private ArrayList<User> Attendees;
	
	public static final Event NO_EVENT = new Event(0, new Date(0));
	
	public Event(int id, Date start)
	{
		ID = id;
		StartTime = start;
		Attendees = new ArrayList<User>();
	}
	
	public boolean addAttendee(User attendee)
	{
		return Attendees.add(attendee);
	}
	
	public boolean setTime(Date time)
	{
		StartTime = time;
		return true;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public Date getTime()
	{
		return StartTime;
	}
	
	public ArrayList<User> getAttendees()
	{
		return Attendees;
	}
}
