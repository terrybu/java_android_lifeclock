package com.bucifer.lifeclock_english;

public class Calculations {
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
    
	public static String comments() {
		if (hourMark == 0)
        {
			lifeClockDisplay = "12:" + paddingMinute + "AM";
      	return "Are you a baby? Did you open this app by accident? ;) ";
        }
         // Very early morning
		else if (hourMark > 0 && hourMark < 6)
        { 
			lifeClockDisplay = hourMark + ":" + paddingMinute + "AM" ;
      	return "Everyone else is pretty much sleeping. No need to be in a hurry!";
        }
         // Early morning 
		else if (hourMark >= 6 && hourMark < 9)
        {
			lifeClockDisplay = hourMark + ":" + paddingMinute + "AM" ;
	        return "Morning has just started. It's a good time to plan out the rest of the day."
      		+ "You have your whole day ahead of you.";
        }
         // Late morning
		else if (hourMark >= 9 && hourMark < 12)
        {
			lifeClockDisplay = hourMark + ":" + paddingMinute + "AM" ;
	      	return "It's still morning. You have time to plan out your afternoon and night. You have a plenty of time left. ";
        }
         // Noon
		else if (hourMark == 12)
        {
    		lifeClockDisplay = hourMarkPM + ":" + paddingMinute + "PM" ;
            return "It's lunch time. When you look back at the morning, what did you learn? How can you make your afternoon and night better?";
        }
         // Afternoon
		else if (hourMark > 12 && hourMark <= 18) 
        {
    		lifeClockDisplay = hourMarkPM + ":" + paddingMinute + "PM" ;
          	return "What will you choose to work on this afternoon? How will you plan out your night?";
        }
         // Night
		else if (hourMark > 18 && hourMark < 24){
    		lifeClockDisplay = hourMarkPM + ":" + paddingMinute + "PM" ;
          	return "How do you want to spend the rest of the night? Aren't there still many things you want to do?";
        }
         // Midnight
		else {
			lifeClockDisplay = "12:" + paddingMinute + "AM";
	      	return "How do you want to spend the rest of the night? Aren't there still many things you want to do?";
      	}    
	}
	
}
