package comp_1000_January_assignments;

import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;


public class MyTravelPlanner {
	
//Practicality is vague 
	
	    public static void getPlan(String[] args) {
	        Scanner input = new Scanner(System.in);

	        System.out.printf("Enter the date of your appointment in mm/dd/yyyy format%n");
	        String dateOfPlan = input.next();
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	        LocalDate date1 = LocalDate.parse(dateOfPlan, formatter);

	        DayOfWeek dayOfWeek = date1.getDayOfWeek();
	        String dayofWeektest = dayOfWeek.toString().toUpperCase(); // Correct formatting

	        System.out.printf("%s%n", dayOfWeek);

	        System.out.printf("Enter the weather on the date of your appointment %n");
	        String weather = input.next();
	        System.out.printf("%s%n", weather);

	        System.out.printf("Enter the time of your first appointment in hh:mm:ss format%n");
	        String firstAppStart = input.next();
	        DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss");
	        LocalTime time1 = LocalTime.parse(firstAppStart, formatterTime);
	        System.out.printf("%s%n", time1); // Correct formatting

	        System.out.printf("Enter the time of your last appointment in hh:mm:ss format%n");
	        String lastAppStart = input.next();
	        DateTimeFormatter formatterTime2 = DateTimeFormatter.ofPattern("HH:mm:ss");
	        LocalTime time2 = LocalTime.parse(lastAppStart, formatterTime2); // Correct formatter
	        System.out.printf("%s%n", time2);

	        LocalTime timeFinalWeekday = LocalTime.of(23, 00, 00);
	        LocalTime timeFirstWeekday = LocalTime.of(07, 00, 00);
	        LocalTime timeFirstWeekend = LocalTime.of(11, 00, 00);
	        LocalTime timeFinalWeekend = LocalTime.of(22, 00, 00);
	        int timeminutes1 = time1.getMinute();
        	int timeminutes2 = time2.getMinute();
        	int timehours1 = time1.getHour();
        	int timehours2 = time2.getHour();
        	
        	
	     // Instance in which it is rainy/cloudy and you have to take you car during the weekday
        	if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))
        	        && (time2.isAfter(timeFinalWeekday) || time1.isBefore(timeFirstWeekday) || time2.equals(timeFinalWeekday))
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    System.out.println("Please Reschedule your appointment");
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
        	        && (time2.isAfter(timeFinalWeekday) || time1.isBefore(timeFirstWeekday) || time2.equals(timeFinalWeekday))
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime1 = time1.minusHours(1);
        	    System.out.printf("Please drive to your appointment at %s on %s ", DepartureTime1, date1);
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
        	        && (timeminutes1 >= 45)
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime2 = time1.minusHours(1);
        	    System.out.printf("Please drive to your appointment at %s on %s ", DepartureTime2, date1);
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
        	        && ((timeminutes1 < 45) && (timeminutes1 > 30))
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime3 = time1.plusHours(1);
        	    int Rounded3 = (int) (Math.ceil((timeminutes1 / 30)) * 30);
        	    LocalTime DepartureTime3Rounded = DepartureTime3.withMinute(Rounded3);

        	    LocalTime DepartureTime4 = time2.plusHours(1);
        	    int Rounded4 = (int) (Math.ceil((timeminutes2 / 30)) * 30);
        	    LocalTime DepartureTime4Rounded = DepartureTime4.withMinute(Rounded4);

        	    System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime3Rounded, DepartureTime4Rounded, date1);
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
        	        && ((timeminutes1 < 30) && (timeminutes1 >= 15))
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime5 = time1.minusHours(1);
        	    System.out.printf("Please drive to your appointment at %s on %s ", DepartureTime5, date1);
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
        	        && ((timeminutes1 < 15) && (timeminutes1 > 0))
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime6 = time1.minusHours(1);
        	    int Rounded6 = (int) (Math.ceil((timeminutes1 / 30)) * 30);
        	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

       			
       			LocalTime DepartureTime7 = time2.plusHours(1);
       			int Rounded7 = (int) (Math.ceil((timeminutes2/30))*30);
       			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
       			
   	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
       		
        	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))
        	        &&(time2.isBefore(timeFinalWeekday) || time1.isAfter(timeFirstWeekday) || time2 != timeFinalWeekday)
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime6 = time1.minusHours(1);
        	    int Rounded6 = Math.round((timeminutes1 / 30)) * 30;
        	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

       			
       			LocalTime DepartureTime7 = time2.plusHours(1);
       			int Rounded7 = (int) (Math.ceil(timeminutes2/30))*30;
       			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
       			
   	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
       		
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy")|| weather.equalsIgnoreCase("Rainy")|| weather.equalsIgnoreCase("Snowy"))
        	        && (timeminutes1 == 30) 
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        		 LocalTime DepartureTime8 = time1.plusHours(1);

       			
       			LocalTime DepartureTime9 = time2.minusHours(1);
       			int Rounded9 = (int) (Math.ceil((timeminutes2/30))*30);
       			LocalTime DepartureTime9Rounded = DepartureTime9.withMinute(Rounded9);
       			
   	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime8, DepartureTime9Rounded, date1);
       		
        	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy")|| weather.equalsIgnoreCase("Rainy")|| weather.equalsIgnoreCase("Snowy"))
        	        && (timeminutes1 == 0)
        	        && (dayofWeektest.equalsIgnoreCase("MONDAY") || dayofWeektest.equalsIgnoreCase("TUESDAY") ||
        	                dayofWeektest.equalsIgnoreCase("WEDNESDAY") || dayofWeektest.equalsIgnoreCase("THURSDAY") || dayofWeektest.equalsIgnoreCase("FRIDAY"))) {
        	    LocalTime DepartureTime10 = time1.minusHours(1);
        	    
       			
       			LocalTime DepartureTime11 = time2.plusHours(1);
       			int Rounded11 = (int) (Math.ceil((timeminutes2/30))*30);
       			LocalTime DepartureTime11Rounded = DepartureTime11.withMinute(Rounded11);
       			
   	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime10, DepartureTime11Rounded, date1);
       		 
	            
	            
	            
	            
	            
	            
// Instance in which it is rainy/snowy and you have to reschedule on the weekend. 
        	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))
         	        && (time2.isAfter(timeFinalWeekend) || time1.isBefore(timeFirstWeekend) || time2.equals(timeFinalWeekend))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         	    System.out.println("Please Reschedule your appointment");
         	} else if ((weather.equalsIgnoreCase("Sunny") || weather.equalsIgnoreCase("Cloudy"))
         	        && (time2.isAfter(timeFinalWeekend) || time1.isBefore(timeFirstWeekend) || time2.equals(timeFinalWeekend))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {

         	    LocalTime DepartureTime1 = time1.minusHours(1);
         	    System.out.printf("Please drive to your appointment at %s on %s", DepartureTime1, date1);
         	    
         	    // Rainy/Snowy days when you have to take the train
         	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))&&
         			( (timehours1 == 11) || (timehours1 == 13) || (timehours1 == 15) || (timehours1 == 17) || (timehours1 == 19) 
         	        		|| (timehours1 == 21)) &&
         	       ( (timehours2 == 11) || (timehours2 == 13) || (timehours2 == 15) || (timehours2 == 17) || (timehours2 == 19) 
        	        		|| (timehours2 == 21))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         		
         		LocalTime DepartureTime6 = time1.minusHours(1);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(1);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
        
         	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))&&
         	        ( (timehours1 == 11) || (timehours1 == 13) || (timehours1 == 15) || (timehours1 == 17) || (timehours1 == 19) 
         	        		|| (timehours1 == 21)) &&
         	       ( (timehours2 == 12) || (timehours2 == 14) || (timehours2 == 16) || (timehours2 == 18) || (timehours2 == 20))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         		
         		LocalTime DepartureTime6 = time1.minusHours(1);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(2);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
    	            
         	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy")) &&
         	        ( (timehours1 == 12) || (timehours1 == 14) || (timehours1 == 16) || (timehours1 == 18) || (timehours1 == 20) 
         	        		|| (timehours1 == 21)) &&
         	       ( (timehours2 == 11) || (timehours2 == 13) || (timehours2 == 15) || (timehours2 == 17) || (timehours2 == 19) 
        	        		|| (timehours2 == 21))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         		
         		LocalTime DepartureTime6 = time1.minusHours(2);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(2);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
    	            
         	} else if ((weather.equalsIgnoreCase("Rainy") || weather.equalsIgnoreCase("Snowy"))&&
         	        ( (timehours1 == 12) || (timehours1 == 14) || (timehours1 == 16) || (timehours1 == 18) || (timehours1 == 20)) &&
         	       ( (timehours2 == 12) || (timehours2 == 14) || (timehours2 == 16) || (timehours2 == 18) || (timehours2 == 20) 
        	        		)
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         		
         		LocalTime DepartureTime6 = time1.minusHours(1);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(1);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
    	                
    	            
    	            
    	        // Sunny/Cloudy Days When you have to take the train. It is only practical to wait 15 minutes. So this is the only instance in which one would take the train.    
         	} else if ((weather.equalsIgnoreCase("Cloudy")|| weather.equalsIgnoreCase("Sunny"))
         	        && (timeminutes1 <= 15) &&
         	        ((timehours1 == 12) || (timehours1 == 14) || (timehours1 == 16) || (timehours1 == 18)|| (timehours1 == 20))
         	       &&((timehours2 == 12) || (timehours2 == 14) || (timehours2 == 16) || (timehours2 == 18) || (timehours2 == 20))
         	        
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         	 
        		LocalTime DepartureTime6 = time1.minusHours(1);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(2);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
    	          
         	} else if ((weather.equalsIgnoreCase("Cloudy")|| weather.equalsIgnoreCase("Sunny"))
         	        && (timeminutes1 <= 15) &&
         	        ((timehours1 == 12) || (timehours1 == 14) || (timehours1 == 16) || (timehours1 == 18)|| (timehours1 == 20))
         	       &&((timehours2 == 11) || (timehours2 == 13) || (timehours2 == 15) || (timehours2 == 17) || (timehours2 == 19)|| (timehours2 == 21))
         	        
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         	 
        		LocalTime DepartureTime6 = time1.minusHours(1);
         	    int Rounded6 = 0;
         	    LocalTime DepartureTime6Rounded = DepartureTime6.withMinute(Rounded6);

        			
        			LocalTime DepartureTime7 = time2.plusHours(1);
        			int Rounded7 = 0;
        			LocalTime DepartureTime7Rounded = DepartureTime7.withMinute(Rounded7);
        			
    	            System.out.printf("Please take the %s train to go to the city, and take the %s train to get back home on %s", DepartureTime6Rounded, DepartureTime7Rounded, date1);
    	          
    	            
    	            
         	    
         	    //Sunny/Cloudy days when you have to drive. 
         	} else if ((weather.equalsIgnoreCase("Cloudy")|| weather.equalsIgnoreCase("Rainy"))
         	        && (timeminutes1 > 15) &&
         	        ((timehours1 == 11) || (timehours1 == 13) || (timehours1 == 15) || (timehours1 == 17) 
         	        		|| (timehours1 == 19)|| (timehours1 == 21))
         	        && (dayofWeektest.equalsIgnoreCase("SATURDAY") || dayofWeektest.equalsIgnoreCase("SUNDAY"))) {
         	 
         		 LocalTime DepartureTime1 = time1.minusHours(1);
          	    System.out.printf("Please drive to your appointment at %s on %s ", DepartureTime1, date1);

        
	       
	        } else  System.out.printf("INVALID"); 
	        

	    }

}
