package com.bucifer.lifeclock_english;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainClock extends Activity {

	public void outOfRangeTest (String place, Intent x) {
		if (place.equals("")){
			AlertDialog.Builder builder = new AlertDialog.Builder(MainClock.this);
			builder.setMessage(R.string.outofrange);
			builder.setCancelable(true);
			builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				@Override
				public void onClick(DialogInterface dialog, int which) {
//					MainActivity.this.finish();
//					this above alert clicktype exits out of the application completely to the home screen
					dialog.cancel();
				}
			});
	    	MediaPlayer mp = MediaPlayer.create (MainClock.this, R.raw.beep);
    		mp.start();
			AlertDialog alert = builder.create();
			alert.show();
		}
		else{
			int p = Integer.parseInt(place);
			if (p > 80 || p < 1){
				AlertDialog.Builder builder = new AlertDialog.Builder(MainClock.this);
				builder.setMessage(R.string.outofrange);
				builder.setCancelable(true);
				builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});
		    	MediaPlayer mp = MediaPlayer.create (MainClock.this, R.raw.beep);
        		mp.start();
				AlertDialog alert = builder.create();
				alert.show();
			}
			else{
				x.putExtra("theAge", place);
		    	MediaPlayer mp = MediaPlayer.create (MainClock.this, R.raw.particle_unlock);
        		mp.start();
				startActivity(x);
				}
			}
    }
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainactivity);
        Button b = (Button) findViewById(R.id.button1);
        b.setOnClickListener(new OnClickListener() {		
        	public void onClick(View v) {

		    	EditText ageInput = (EditText) findViewById(R.id.editText1); 
		    	final Intent intent = new Intent(MainClock.this, ResultPage.class);	
		    	String placeholder = ageInput.getText().toString().trim();
				outOfRangeTest(placeholder, intent);
			}
		});
		
        
    }
}