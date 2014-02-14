package com.mvqkc.androidapplication;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Countrypage extends Activity {
	
	Button chanarea;
	TextView display;
	EditText getzipc;
	String temperature;
	String wea;
	String jsonstring;
	String city;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.countrypage);
			
		chanarea = (Button)findViewById(R.id.button1);
		display = (TextView)findViewById(R.id.disp);
		getzipc = (EditText)findViewById(R.id.getzip);
				
		chanarea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
					HttpClient htp = new DefaultHttpClient();
					Editable add = getzipc.getText();
					String url="http://where.yahooapis.com/v1/states/"+add.toString()+"?format=json&appid=[849776bfc1ae224700368af84a2e9e3e7b23cfa3]";
					HttpResponse response =null;
					
					HttpPost htppost = new HttpPost(url);
					try{
						response = htp.execute(htppost);
					}catch (ClientProtocolException e1){
						e1.printStackTrace();
					}catch (IOException e1){
						e1.printStackTrace();
					}
					StatusLine statusline = response.getStatusLine();
					if(statusline.getStatusCode()==HttpStatus.SC_OK)
					{
						ByteArrayOutputStream out = new ByteArrayOutputStream();
						try{
							response.getEntity().writeTo(out);
							
						}catch (IOException e){
							e.printStackTrace();
						}
						try{ 
							out.close();
						}catch (IOException e){
							e.printStackTrace();
						}
						jsonstring = out.toString();
					}
					//try{
						//JSONObject obs = new JSONObject(jsonstring);
						//JSONObject obi = obs.getJSONObject("places");
						//JSONObject obj = obi.getJSONObject("place");
						//temperature = obj.getString("total");
						
						
				//	}catch(JSONException e){
					//	e.printStackTrace();
				//	}
					
					display.setText("Country : "+add.toString()+"\nStates and Territories : 51");

							
							}
		});

	}

}
