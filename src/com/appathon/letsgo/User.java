package com.appathon.letsgo;

/*
 * User object.
 */

public class User {

    private int SID;
	private String NickName;
	private String PhoneNumber;
	
	public final static User NO_ONE = new User("Does not exist", "(000) 000-0000", 0);
	
	public User(String nickName, String number, int sid)
	{
		NickName = nickName;
		PhoneNumber = number;
        SID = sid;
	}

    public String toJSONString()
    {
        return "THIS IS A TEMPORARY VALUE";
    }

    public int getSID()
    {
        return SID;
    }
	
	public String getNickName()
	{
		return NickName;
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
