package com.appathon.letsgo;

import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class LetsGo_Main extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lets_go__main);

        Button button = (Button)findViewById(R.id.button1);
        OnClickListener o = new View.OnClickListener() {
        	@Override 
            public void onClick(View arg0) {
                Intent myIntent = new Intent(LetsGo_Main.this, EventDetails.class);
                LetsGo_Main.this.startActivity(myIntent);
                // TODO Auto-generated method stub
            }
        };
        button.setOnClickListener(o);
        
        /*Button button2 = (Button)findViewById(R.id.button2);
        OnClickListener on = new View.OnClickListener() {
        	@Override 
            public void onClick(View arg0) {
                Intent myIntent = new Intent(LetsGo_Main.this, AddEvent.class);
                LetsGo_Main.this.startActivity(myIntent);
                // TODO Auto-generated method stub
            }
        };
        button2.setOnClickListener(on);*/
    }
    

}
