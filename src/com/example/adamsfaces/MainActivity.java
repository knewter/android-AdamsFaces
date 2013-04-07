package com.example.adamsfaces;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends Activity {
	
	private Button mGracie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mGracie = (Button) findViewById(R.id.btnGracie);
        mGracie.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				playGracieSound();
			}
		});
    }
    
    private void playGracieSound() {
    	MediaPlayer player = MediaPlayer.create(this, R.raw.graciesound);
    	player.start();
    	player.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion(MediaPlayer mp) {
				// Release player.
				mp.release();
			}
		});
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
