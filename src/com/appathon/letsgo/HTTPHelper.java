package com.appathon.letsgo;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.sql.Date;
import java.sql.Time;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class HTTPHelper {

	private final String URL_GET_USER = "", URL_DEL_USER = "",
			URL_CRT_USER = "", URL_GET_EVNT = "", URL_DEL_EVNT = "",
			URL_CRT_EVNT = "", URL_ATN_EVNT = "";

	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";

	public JSONObject getJSONFromUrl(String url) {

		// Making HTTP request
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			HttpResponse httpResponse = httpClient.execute(httpPost);
			HttpEntity httpEntity = httpResponse.getEntity();
			is = httpEntity.getContent();

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					is, "iso-8859-1"), 8);
			StringBuilder sb = new StringBuilder();
			String line = null;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			is.close();
			json = sb.toString();
		} catch (Exception e) {
			Log.e("Buffer Error", "Error converting result " + e.toString());
		}

		// try parse the string to a JSON object
		try {
			jObj = new JSONObject(json);
		} catch (JSONException e) {
			Log.e("JSON Parser", "Error parsing data " + e.toString());
		}

		// return JSON String
		return jObj;

	}

	/*
	 * Expects
	 * users: [ {nickName: String} {number: String} {sid: int} ]
	 */
	// returns the User object corresponding to the sid
	public User GetUser(int sid) {
		JSONObject reader = getJSONFromUrl(URL_GET_USER);
		
		try {
			JSONArray users = reader.getJSONArray("users");
			for(int i = 0; i < users.length(); i++)
				if(users.getJSONObject(i).getInt("sid") == sid)
					return new User(reader.getString("nickName"), reader.getString("number"), reader.getInt("sid"));
		} catch (JSONException e) {
		}
		return User.NO_ONE;
	}

	// deletes the User object corresponding to the sid
	// returns true if User was deleted successfully, false otherwise
	public boolean DeleteUser(int sid) {
		return false;
	}

	public boolean CreateUser(User user) {
		return false;
	}

	/*
	 * Expects
	 * events: [ {id: String} {start: long} ]
	 */
	public com.appathon.letsgo.Event GetEvent(int eventID) {
		JSONObject reader = getJSONFromUrl(URL_GET_EVNT);
		
		try {
			JSONArray users = reader.getJSONArray("events");
			for(int i = 0; i < users.length(); i++)
				if(users.getJSONObject(i).getInt("id") == eventID)
					return new com.appathon.letsgo.Event(
							users.getJSONObject(i).getInt("id"),
							new Date(users.getJSONObject(i).getInt("start")));
		} catch (JSONException e) {
		}
		return com.appathon.letsgo.Event.NO_EVENT;
	}

	public boolean DeleteEvent(int eventID) {
		return false;
	}

	public boolean CreateEvent(Event event) {
		return false;
	}

	public boolean AttendEvent(Event event, User user) {
		return false;
	}
}