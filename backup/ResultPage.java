package com.bucifer.lifeclock_english;
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends Activity {
	public static int hourMark;
	public static int hourMarkPM;
	public static int minuteMark;
	public static int time;
	public static String paddingMinute;   
	public static int age;
	public static String lifeClockDisplay;
	
	public static void calculation(int a){
        time = a * 18;
        minuteMark = (a * 18) % 60;
        hourMark = (time - minuteMark)/60;
        hourMarkPM = hourMark - 12;
        if (minuteMark < 10){
        	paddingMinute = "0" + String.valueOf(minuteMark);
        }
        else{
        	paddingMinute = String.valueOf(minuteMark);
        }
	}
    public static void resultInputCalc() 
	{	//AM
        if (hourMark >= 0 && hourMark < 12)
        {
			if (hourMark == 0)
			{
				lifeClockDisplay = "12:" + paddingMinute + "AM";
			}
			else 
			{
				lifeClockDisplay = hourMark + ":" + paddingMinute + "AM" ;
			}
        }
        //PM
        if (hourMark >= 12 && hourMark < 24)
        {
    		lifeClockDisplay = hourMarkPM + ":" + paddingMinute + "PM" ;
        }
        //Midnight
        if (hourMark == 24)
        {
    		lifeClockDisplay = hourMarkPM + ":" + paddingMinute + "AM" ;
        }
	}
	public static String comments() {
		if (hourMark == 0)
        {
      	return "Are you a baby? Did you open this app by accident? ;) ";
        }
         // Very early morning
		else if (hourMark > 0 && hourMark < 6)
        { 
      	return "Everyone else is pretty much sleeping. No need to be in a hurry!";
        }
         // Early morning 
		else if (hourMark >= 6 && hourMark < 9)
        {
          return "Morning has just started. It's a good time to plan out the rest of the day."
          		+ "You have your whole day ahead of you.";
        }
         // Late morning
		else if (hourMark >= 9 && hourMark < 12)
        {
      	return "It's still morning. You have time to plan out your afternoon and night. You have a plenty of time left. ";
        }
         // Noon
		else if (hourMark == 12)
        {
          return "It's lunch time. When you look back at the morning, what did you learn? How can you make your afternoon and night better?";
        }
         // Afternoon
		else if (hourMark > 12 && hourMark <= 18) 
        {
      	return "What will you choose to work on this afternoon? How will you plan out your night?";
        }
         // Night
		else if (hourMark > 18 && hourMark < 24){
      	return "How do you want to spend the rest of the night? Aren't there still many things you want to do?";
        }
         // Midnight
		else {
      	return "How do you want to spend the rest of the night? Aren't there still many things you want to do?";
      	}    
	}
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.result);
		
		TextView resultIntroView = (TextView) findViewById(R.id.result_intro_text);
		resultIntroView.setText("Your current age is " + getIntent().getExtras().getString("theAge") + " years-old and " + "your life clock is pointing to ...");
		
		TextView intTestView = (TextView) findViewById(R.id.clock_display_view);
		age = Integer.parseInt(getIntent().getExtras().getString("theAge")); //here is the user-input for age saved
		calculation(age);
		resultInputCalc();
		intTestView.setText(lifeClockDisplay); 		
		//so you can do something like intTestView.setText("" + age)
		//apparently "" + integer value makes that integer into string. neat quick trick
				
		//Now, this below code creates the Textview variable commentsView and then
		//displays the bottom Textview to display your comments through the method you created below. 
		TextView commentsView = (TextView) findViewById(R.id.result_comments);
		commentsView.setText(comments());
		
	}
	
}
