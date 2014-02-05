package com.mvqkc.weatherdisplay;

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

public class Secondpg extends Activity {

	
	Button getdata;
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
		setContentView(R.layout.thirdpg);
		
		getdata = (Button)findViewById(R.id.button1);
		chanarea = (Button)findViewById(R.id.button2);
		display = (TextView)findViewById(R.id.disp);
		getzipc = (EditText)findViewById(R.id.getzip);
		
		getdata.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HttpClient htp = new DefaultHttpClient();
				String url="http://api.wunderground.com/api/36b799dc821d5836/conditions/q/64112.json";
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
				try{
					JSONObject obs = new JSONObject(jsonstring);
					JSONObject obj = obs.getJSONObject("current_observation");
					temperature = obj.getString("temp_f");
					wea = obj.getString("weather");
					JSONObject obj1 = obj.getJSONObject("display_location");
					city = obj1.getString("city");
				}catch(JSONException e){
					e.printStackTrace();
				}
				
				display.setText("Climate in \n City : "+city+" \n Temperature : "+ temperature +" F\n Weather:"+ wea);

				
			}
		});
		
		chanarea.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				HttpClient htp = new DefaultHttpClient();
				Editable add= getzipc.getText();
				String url="http://api.wunderground.com/api/36b799dc821d5836/conditions/q/"+add.toString()+".json";
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
				try{
					JSONObject obs = new JSONObject(jsonstring);
					JSONObject obj = obs.getJSONObject("current_observation");
					temperature = obj.getString("temp_f");
					wea = obj.getString("weather");
					JSONObject obj1 = obj.getJSONObject("display_location");
					city = obj1.getString("city");
				}catch(JSONException e){
					e.printStackTrace();
				}
				
				display.setText("Climate in \n City : "+city+" \n Temperature : "+ temperature +" F\n Weather:"+ wea);


				
							}
		});
		
		
		
	}
	
}
