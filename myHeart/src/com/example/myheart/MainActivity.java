package com.example.myheart;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.webkit.WebView;



public class MainActivity extends Activity {

	public WebView web1;
	public  MediaPlayer mp;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       
        
    	web1 = (WebView) findViewById(R.id.webView1);
		//web1.setWebViewClient(new wweb_clien());
		//web1.getSettings().setJavaScriptEnabled(true);
		web1.setInitialScale(100);
		web1.loadUrl("file:///android_asset/myheartbeat.html");
		
		//mp = MediaPlayer.create(this, R.raw.beat);
		mp = MediaPlayer.create(this, R.raw.nois_heart);
		mp.setLooping(true);
		mp.start();
		
		long[] pattern = {0, 20, 500};
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		v.vibrate(pattern,0);
    }
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onStop(){
    	super.onStop();
    	
    		mp.stop();
    		long[] pattern = {0, 10, 10};
    		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    		v.vibrate(pattern,0);
    		v.cancel();   	
    }
    
 
    
    @Override
    protected void onPause(){
    	super.onPause();
    	
    		mp.stop();
    		long[] pattern = {0, 10, 10};
    		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    		v.vibrate(pattern,0);
    		v.cancel();
    	
    } 
    
    @Override
    protected void onDestroy(){
    	super.onDestroy();    	
    		mp.stop();
    		long[] pattern = {0, 10, 10};
    		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
    		v.vibrate(pattern,0);
    		v.cancel();
    	
    } 
    
    @Override
    protected void onRestart(){
    	super.onRestart();
    	
    	mp = MediaPlayer.create(this, R.raw.nois_heart);
		mp.setLooping(true);
		mp.start();
		
		long[] pattern = {0, 20, 500};
		Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);

		v.vibrate(pattern,0);
    	
    } 
    
}
