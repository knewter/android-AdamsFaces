package com.example.adamsfaces;

import android.app.Activity;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

  private Button mGracie;
  private Button mMatthew;
  private Button mJosh;
  private Button mKristen;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mGracie = (Button) findViewById(R.id.btnGracie);
    mGracie.setOnClickListener(new SoundClickListener(R.raw.graciesound));

    mMatthew = (Button) findViewById(R.id.btnMatthew);
    mMatthew.setOnClickListener(new SoundClickListener(R.raw.matthewsound));

    mJosh = (Button) findViewById(R.id.btnJosh);
    mJosh.setOnClickListener(new SoundClickListener(R.raw.joshsound));

    mKristen = (Button) findViewById(R.id.btnKristen);
    mKristen.setOnClickListener(new SoundClickListener(R.raw.kristensound));
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  private class SoundClickListener implements OnClickListener {
    int mSoundFileResource;

    public SoundClickListener(int soundFileResource){
      mSoundFileResource = soundFileResource;
    }

    @Override
    public void onClick(View view) {
      playSound(view);
    }

    private void playSound(View view) {
      MediaPlayer player = MediaPlayer.create(view.getContext(), mSoundFileResource);
      player.start();
      player.setOnCompletionListener(new OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
          // Release player.
          mp.release();
        }
      });
    }

  }
}
