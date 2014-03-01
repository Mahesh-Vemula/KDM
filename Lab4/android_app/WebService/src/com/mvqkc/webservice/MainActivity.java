package com.mvqkc.webservice;

import android.os.Bundle;
import android.app.Activity;
import android.text.Editable;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	WebView linkurl;
	Button but;
	EditText dat;
	String url;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		but = (Button)findViewById(R.id.button1);
		dat = (EditText)findViewById(R.id.editText1);
		
		but.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Editable add= dat.getText();
				url="http://www."+add.toString()+".com";
				linkurl = (WebView)findViewById(R.id.webView1);
				linkurl.getSettings().setJavaScriptEnabled(true);
				linkurl.loadUrl(url);
				
			}
		});
		
		
		linkurl = (WebView)findViewById(R.id.webView1);
		linkurl.getSettings().setJavaScriptEnabled(true);
		linkurl.loadUrl(url);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
