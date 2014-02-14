package com.mvqkc.androidapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secondpage extends Activity {

	Button contry;
	Button wether;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secondpage);
		
		contry = (Button)findViewById(R.id.button2);
		wether = (Button)findViewById(R.id.button1);
		
		wether.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent weapage = new Intent("com.mvqkc.androidapplication.WEATHERPAGE");
				startActivity(weapage);				
				
			}
		});
		
		contry.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent conpage = new Intent("com.mvqkc.androidapplication.COUNTRYPAGE");
				startActivity(conpage);				
				
			}
		});
		
		
		
	}
	
	
	
	
	
}
