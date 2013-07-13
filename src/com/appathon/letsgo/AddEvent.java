package com.appathon.letsgo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddEvent extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		
		Button button = (Button)findViewById(R.id.button1);
        OnClickListener o = new View.OnClickListener() {
        	@Override 
            public void onClick(View arg0) {
                Intent myIntent = new Intent(AddEvent.this, EventDetails.class);
                AddEvent.this.startActivity(myIntent);
                // TODO Auto-generated method stub
            }
        };
        button.setOnClickListener(o);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_event, menu);
		return true;
	}

}
