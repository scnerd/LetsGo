package com.appathon.letsgo;

import java.io.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.*;

import android.util.Log;

public class HTTPHelper {

	//Need values
	private static final String URL_GET_USER = "", URL_DEL_USER = "",
			URL_CRT_USER = "", URL_GET_EVNT = "", URL_DEL_EVNT = "",
			URL_CRT_EVNT = "", URL_ATN_EVNT = "", URL_GET_EVNT_ATNS = "";
	
	public static final int
		ST_ABSENT = 0,
		ST_GOING  = 1,
		ST_DRIVING = 2;

	static InputStream is = null;
	static JSONObject jObj = null;
	static String json = "";

	private static JSONObject getJSONFromUrl(String url, List<NameValuePair> pairs)
			throws JSONException {

		// Making HTTP request
		try {
			// defaultHttpClient
			DefaultHttpClient httpClient = new DefaultHttpClient();
			HttpPost httpPost = new HttpPost(url);

			httpPost.setEntity(new UrlEncodedFormEntity(pairs));

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
		jObj = new JSONObject(json);

		// return JSON String
		return jObj;

	}

	/*
	 * Expects users: [ {nickName: String} {number: String} {sid: int} ]
	 */
	// returns the User object corresponding to the sid
	public static User GetUser(int sid) {
		JSONObject reader;
		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("SID", Integer.valueOf(sid).toString()));
			reader = getJSONFromUrl(URL_GET_USER, params);

			return new User(reader.getString("NickName"),
					reader.getString("Number"), reader.getInt("SID"));
		} catch (JSONException e) {
		}

		return User.NO_ONE;
	}

	// deletes the User object corresponding to the sid
	// returns true if User was deleted successfully, false otherwise
	public static boolean DeleteUser(int sid) {
		JSONObject reader;

		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("SID", Integer.valueOf(sid).toString()));
			reader = getJSONFromUrl(URL_DEL_USER, params);
			if(reader.length() > 0)
				return true;
		} catch (JSONException e) {
		}
		return false;
	}

	public static boolean CreateUser(User user) {
		JSONObject reader;

		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("SID", Integer.valueOf(user.getSID()).toString()));
			params.add(new BasicNameValuePair("NickName", user.getNickName()));
			params.add(new BasicNameValuePair("Number", user.getPhoneNumber()));
			reader = getJSONFromUrl(URL_CRT_USER, params);
			if(reader.length() > 0)
				return true;
		} catch (JSONException e) {
		}
		return false;
	}

	public static com.appathon.letsgo.Event GetEvent(int eventID) {
		JSONObject reader;
		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", Integer.valueOf(eventID).toString()));
			reader = getJSONFromUrl(URL_GET_EVNT, params);

			return new Event(reader.getInt("ID"), Date.valueOf(reader.getString("Start")));
		} catch (JSONException e) {
		}

		return Event.NO_EVENT;
	}

	public static boolean DeleteEvent(int eventID) {
		JSONObject reader;

		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", Integer.valueOf(eventID).toString()));
			reader = getJSONFromUrl(URL_DEL_EVNT, params);
			if(reader.length() > 0)
				return true;
		} catch (JSONException e) {
		}
		return false;
	}

	public static boolean CreateEvent(Event event) {
		JSONObject reader;

		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", Integer.valueOf(event.getID()).toString()));
			params.add(new BasicNameValuePair("Start", event.getStartTime().toString()));
			params.add(new BasicNameValuePair("Location", event.getLocation()));
			params.add(new BasicNameValuePair("Cost", event.getCost()));
			params.add(new BasicNameValuePair("POC", Integer.valueOf(event.getPOC()).toString()));
			reader = getJSONFromUrl(URL_CRT_EVNT, params);
			if(reader.length() > 0)
				return true;
		} catch (JSONException e) {
		}
		return false;
	}

	public static boolean AttendEvent(Event event, User user, int State) {
		JSONObject reader;

		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", Integer.valueOf(event.getID()).toString()));
			params.add(new BasicNameValuePair("SID", Integer.valueOf(user.getSID()).toString()));
			params.add(new BasicNameValuePair("Driving", Integer.valueOf(State).toString()));
			reader = getJSONFromUrl(URL_ATN_EVNT, params);
			if(reader.length() > 0)
				return true;
		} catch (JSONException e) {
		}
		return false;
	}
	
	public static User[] GetAttendees(int eventID) {
		JSONObject reader;
		try {
			ArrayList<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("ID", Integer.valueOf(eventID).toString()));
			reader = getJSONFromUrl(URL_GET_EVNT_ATNS, params);
			JSONArray attns = reader.getJSONArray("Attendees");
			
			//Loop through the JSON array, and query for each user who is attending
			User[] attns_info = new User[attns.length()];
			for(int i = 0; i < attns.length(); i++) {
				attns_info[i] = GetUser(attns.getJSONObject(i).getInt("SID"));
			}
			return attns_info;
		} catch (JSONException e) {
		}

		return new User[0];
	}
}
