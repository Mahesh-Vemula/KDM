package com.mvqkc.androidapplication;



import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity {

	
	MediaPlayer oursong;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		oursong = MediaPlayer.create(MainActivity.this, R.raw.music);
		oursong.start();
		
		Thread timer = new Thread(){
			public void run(){
				try{
					sleep(2000);
					
				}catch(InterruptedException e){
					e.printStackTrace();
				}finally{
					Intent openStartingPoint = new Intent("com.mvqkc.androidapplication.SECONDPAGE");
					startActivity(openStartingPoint);
				}
			}
			
		};
		timer.start();
		
		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
	
		oursong.release();
		finish();
		
	}

	
}
