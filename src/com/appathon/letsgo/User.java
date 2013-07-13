package com.appathon.letsgo;

/*
 * User object.
 */

public class User {

    private String SID;
	private String NickName;
	private String PhoneNumber;
	
	public final static User NO_ONE = new User("Does not exist", "(000) 000-0000", "");
	
	public User(String nickName, String number, String sid)
	{
		NickName = nickName;
		PhoneNumber = number;
        SID = sid;
	}

    public String toJSONString()
    {
        return "THIS IS A TEMPORARY VALUE";
    }

    public String getSID()
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
