package com.appathon.letsgo;

/*
 * User object.
 */

public class User {

	private String Name;
	private String PhoneNumber;
	
	public User(String person, String number)
	{
		Name = person;
		PhoneNumber = number;
	}
	
	public String getName()
	{
		return Name;
	}
	
	public String getPhoneNumber()
	{
		return PhoneNumber;
	}
	
	public boolean setPhoneNumber(String newNumber)
	{
		PhoneNumber = newNumber;
		return true;
	}
}
