package com.bucifer.lifeclock_english;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

public class ResultPage extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		String a = "You are currently ";
		String b1 = " year-old and ";
		String b2 = " years-old and ";
		String c = "Your life-clock is pointing to ...";
		TextView resultIntroView = (TextView) findViewById(R.id.result_intro_text);
		TextView intTestView = (TextView) findViewById(R.id.clock_display_view);
		Calculations.age = Integer.parseInt(getIntent().getExtras().getString("theAge")); //here is the user-input for age saved
		Calculations.calculation(Calculations.age);
		if (Calculations.age == 0) {
		resultIntroView.setText(Html.fromHtml(a + "<b>" + getIntent().getExtras().getString("theAge") + "</b>"+ b1 + "<br>" + c));
		}
		else {
		resultIntroView.setText(Html.fromHtml(a + "<b>" + getIntent().getExtras().getString("theAge") + "</b>"+ b2 + "<br>" + c));
		}
		TextView commentsView = (TextView) findViewById(R.id.result_comments);
		commentsView.setText(Calculations.comments());
		intTestView.setText(Calculations.lifeClockDisplay); 		
		
	}
	
}
