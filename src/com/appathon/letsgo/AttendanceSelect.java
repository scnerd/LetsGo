package com.appathon.letsgo;

import org.apache.http.protocol.HTTP;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.support.v4.app.NavUtils;

public class AttendanceSelect extends Activity {

	String SID;
	int eventID;
	Bundle curBundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_attendance_select);
		// Show the Up button in the action bar.
		setupActionBar();
		eventID = 1; //savedInstanceState.getInt("event");
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.attendance_select, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void choose_Ride(View arg0)
	{
		choice_Made(HTTPHelper.ST_GOING);
	}
	
	public void choose_Drive(View arg0)
	{
		choice_Made(HTTPHelper.ST_DRIVING);
	}
	
	public void choose_Absent(View arg0)
	{
		choice_Made(HTTPHelper.ST_ABSENT);
	}

	private void choice_Made(int Choice)
	{
		HTTPHelper.AttendEvent(HTTPHelper.GetEvent(eventID), HTTPHelper.GetUser(SID), Choice);
		
        Intent myIntent = new Intent(AttendanceSelect.this, AttendanceList.class);
//        Bundle extra = new Bundle();
//        extra.putInt("event", eventID);
//        myIntent.putExtras(extra);
        this.startActivity(myIntent);
	}
}
