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
	private String Location;
	private String Cost;
	private String POC;
	
	public static final Event NO_EVENT = new Event(0, new Date(0), "", "", "");
	
	public Event(int id, Date start, String loc, String cost, String poc)
	{
		ID = id;
		StartTime = start;
		Attendees = new ArrayList<User>();
		Location = loc;
		Cost = cost;
		POC = poc;
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

	public String getPOC() {
		return POC;
	}

	public void setPOC(String pOC) {
		POC = pOC;
	}

	public String getCost() {
		return Cost;
	}

	public void setCost(String cost) {
		Cost = cost;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
	public Date getStartTime() {
		return StartTime;
	}

	public void setStartTime(Date startTime) {
		StartTime = startTime;
	}
}
