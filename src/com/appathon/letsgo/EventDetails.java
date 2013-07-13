package com.appathon.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class EventDetails extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_details);
		Button button = (Button)findViewById(R.id.btn_sel_ride);
        Button b = (Button)findViewById(R.id.button2);
		
        button.setOnClickListener(new View.OnClickListener() {
 
            public void onClick(View arg0) {
                Intent myIntent = new Intent(EventDetails.this, AttendanceSelect.class);
                EventDetails.this.startActivity(myIntent);
                // TODO Auto-generated method stub
            }
        });
        
        b.setOnClickListener(new View.OnClickListener() {
        	 
            public void onClick(View arg0) {
                Intent myIntent = new Intent(EventDetails.this, AttendanceList.class);
                EventDetails.this.startActivity(myIntent);
                // TODO Auto-generated method stub
            }
        });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.event_details, menu);
		return true;
	}

}
