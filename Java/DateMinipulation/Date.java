
import java.util.*;
/**
 * Date holds the day month and year that you input and privides multipul ways to
 * manipulate the date enterd.
 * 
 * @author aaron ratcliffe 
 * @version 4/5/2014
 */
public class Date
{
    // constent variables for cheking
    private final int TOTAL_MONTHS_I = 12;
    private final String [] MONTH_NAME_SA = new String[]{"january","febuary","march","april", "may",
            "june","july", "august","september", "october","november","december"};
    
    // variables 
    private int monthI;
    private int dayI;
    private int yearI;
    private int daysInMonthIA [] = new int[]{31,28,31,30,31,30,31,31,30,31,30,31};

    /**
     * Constructor for objects of class Date
     */
    public Date()
    {
        //calling the method to fine tune the date.
        monthI = 4;
        dayI = 6;
        yearI = 2014;
    }

    /**
     * Constructor for objects of class Date
     */
    public Date(int month, int day, int year)
    {
        //cheking input to see if it is valid
        if(checkDate(month, day, year)){
            monthI = month;
            dayI = day;
            yearI = year;
        }
    }

    /**
     * Constructor for objects of class Date
     */
    public Date(String monthName, int day, int year)
    {
        // changing the input month to the standerd format
        String changedMonthName = monthName.toLowerCase();
        changedMonthName.trim();
        //finding the location of the name of the month 
        int month = Arrays.asList(MONTH_NAME_SA).indexOf(changedMonthName) + 1;

        // check if date is valid 
        if(checkDate(month, day, year)){
            dayI = day;
            monthI = month;
            yearI = year;
        }
    }

    /**
     * Constructor for objects of class Date
     */
    public Date(Date bace)
    {
        //cheking to see if it is a leap year
        if(isLeapYear(bace.yearI)){
            daysInMonthIA[1] = 28;
        }
        else{
            daysInMonthIA[1] = 28; 
        }
        dayI = bace.dayI;
        monthI = bace.monthI;
        yearI = bace.yearI;
    }

    /**
     * this creates a new date class whitch adds the input number of days to the date
     * 
     * @param  int  the number of days to add
     * @return     Date  a new date object that contanes the alterd data
     */
    public Date add(int days)
    {
        int day = dayI;
        int month = monthI;
        int year = yearI;

        //adding the new days
        day += days;

        //cheking to see it it is still valid
        while(day > this.daysInMonthIA[month - 1]){
            //removing the number of days in the month you determand has passed
            day -= this.daysInMonthIA[month - 1];
            //increasing the month
            month += 1;
            //cheking to see if the month is still inside the year
            if(month > TOTAL_MONTHS_I){
                year += 1;
                month = 1;
                //cheking for leap year
                if(isLeapYear(year)){
                    daysInMonthIA[1] = 29;  
                }
                //changing back to defalt when not a leap year
                else{
                    daysInMonthIA[1] = 28;  
                }
            }
        }

        //creating the object with the new data and returning it
        return new Date(month, day, year);
    }

    /**
     * this creates a new date class whitch subtracts the number of days enterd 
     * from the origonal date
     * 
     * @param  days  the number of days to subtract from the date
     * @return    Date  a new date object that contanes the alterd data
     */
    public Date subtract(int days)
    {
        int day = dayI;
        int month = monthI;
        int year = yearI;

        //looping while the number of days left to subtract is to large
        while(days > this.daysInMonthIA[month - 1] || days >= day){
            //removing the days avaloble from the number of days left to subtract
            days -= day;
            //decrease the month
            month--;

            //cheking to see if the month is still inside the year
            if(month < 1){
                year--;
                month = TOTAL_MONTHS_I;
                //cheking for leap year
                if(isLeapYear(year)){
                    daysInMonthIA[1] = 29;  
                }
                //changing back to defalt when not a leap year
                else{
                    daysInMonthIA[1] = 28;  
                }
            }

            //setting the number of days equal to the end of the curent month
            day = this.daysInMonthIA[month - 1];

        }
        day -= days;

        //creating the object and returning it
        return new Date(month, day, year);
    }

    /**
     * this checks the date enterd and check to see if it is valid
     * 
     * @param  day, month, year   day enterd, month enterd, year enterd
     * @return     true if the date is valid 
     */
    private boolean checkDate(int month, int day, int year)
    {
        boolean dayB = false;
        boolean monthB = false;
        boolean yearB = false;

        // check if date is valid
        if(year > 0){
            if(month <= TOTAL_MONTHS_I && month > 0){
                //chekes to see if it is a leap year
                if(isLeapYear(year)){
                    daysInMonthIA[1] = 29;  
                }
                else{
                    daysInMonthIA[1] = 28;
                }
                //checkes to see if the day enterd is an acual da
                if(day <= daysInMonthIA[month-1] && day > 0){
                    dayB = true;
                }
                monthB = true;
            }
            yearB = true;
        }

        return dayB && monthB && yearB;
    }

    /**
     * this determans wether the year is a leep year
     * 
     * @param  year    year enterd
     * @return     true if it is a leap year
     */
    public static boolean isLeapYear(int year)
    {
        // check if date is a leap year
        return year % 400 == 0 || year % 100 != 0 && year % 4 == 0;
    }

    /**
     * this determans wether the year is a leep year
     * 
     * @param  void
     * @return     true if it is a leap year
     */
    public boolean isLeapYear()
    {
        // check if date is valid
        return this.yearI % 400 == 0 || this.yearI % 100 != 0 && this.yearI % 4 == 0;
    }

    /**
     * this determans how maney days are betwean two dates
     * 
     * this will be a few days off if you start or end the comparocen on a leap year
     * 
     * @param  other   a difrent instence of the date class
     * @return     int the number of days inbetwean two date input
     */
    public int dateDiff(Date other)
    {
        int days = 0;
        int years = 0;
        int months = 1;

        //cheking to see how grate the difrent in years are
        if(compairYear(other) == 1){
            
            //looping throu each year and adding the number of days in them
            for(; years < this.yearI - other.yearI ; years++){
                //cheking for leap year
                if(isLeapYear(this.yearI + years)){
                    days+= 366;
                }
                else{
                    days+=365;
                }
            }
            //when the first date falls on an eler month then the second date
            if(compairMonth(other) == -1){
                /*
                 * removing all the days of the months that are bwtwean
                 * other.dayI and this.dayI to sett the days counter to the number equivolent to
                 * the last day of the month emedeotly proseading the month that 
                 * contains this.dayI
                 */

                /*
                 * removing the days from the begining of the other month to get to the
                 * last day of the preceading month
                 */
                days -= other.dayI;

                //removing the intervingin months days from the count of days
                for(; months <= other.monthI - this.monthI; months++){
                    days -= (this.daysInMonthIA[other.monthI - months - 1]);
                }

                /*
                 * adding the number of this.dayI to the days count 
                 *inorder to get from the end of the month befor to the corect date.
                 */
                days += this.dayI;
            }
            //when the dates have the same months
            else if(compairMonth(other) == 0){
                //seing whitch day is later in the month
                if(compairDay(other) == 1){
                    days += (this.dayI - other.dayI);
                }
                else{
                    days -= (other.dayI - this.dayI);
                }         
            }
            //when the staring date has a latter month then the other date
            else{
                /*
                 * adding all the days of the months that are bwtwean
                 * this.dayI and other.dayI to sett the days counter to the number equivolent to
                 * the last day of the month emedeotly proseading the month that 
                 * contains other.dayI
                 */

                /*
                 * removing the days from the begining of the other month to get to the
                 * last day of the preceading month
                 */
                days -= other.dayI;

                //adding the interveaning months days to the days count
                for(; months <= this.monthI - other.monthI; months++){
                    days += (this.daysInMonthIA[other.monthI + months - 1]);
                }

                /*
                 * adding the number of this.dayI to the days count 
                 * inorder to get from the end of the month befor to the corect date.
                 */
                days += this.dayI;
            }
        }
        //the years are the same
        else if(compairYear(other) == 0){
            //when the first date falls on an eler month then the second date
            if(compairMonth(other) == -1){

                //making the days counter equal the number of days left in the month this.monthI
                days = daysInMonthIA[this.monthI - 1] - this.dayI;

                /*
                 * adding the days in the months betwean this.monthI and other.monthI
                 * to the days counter to get us to the last day of the month preceading 
                 * the other.dayI date
                 */
                for(; months < other.monthI - this.monthI; months++){
                    days += (daysInMonthIA[this.monthI + months - 1]);
                }

                /*
                 * adding the number of other.dayI to the days count 
                 *inorder to get from the end of the month befor to the corect date.
                 */
                days += other.dayI;
            }
            //when the dates have the same months
            else if(compairMonth(other) == 0){
                //seing whitch day is later in the month
                if(compairDay(other) == 1){
                    days += (this.dayI - other.dayI);
                }
                else{
                    days += (other.dayI - this.dayI);
                }         
            }
            //when the staring date has a latter month then the other date
            else{
                //making the days counter equal the number of days left in the month other.monthI
                days = daysInMonthIA[other.monthI - 1] - other.dayI;

                /*
                 * adding the days in the months betwean this.monthI and other.monthI
                 * to the days counter to get us to the last day of the month preceading 
                 * the this.dayI date
                 */
                for(; months < this.monthI - other.monthI; months++){
                    days += (daysInMonthIA[other.monthI + months - 1]);
                }

                /*
                 * adding the number of this.dayI to the days count 
                 *inorder to get from the end of the month befor to the corect date.
                 */
                days += this.dayI;
            }
        }
        //when the starting date falls on an ealear year then the end date
        else{
            /*
             * testing to see if the date is starting on or ending in a leap year where the extra day 
             * would not facter into the calculation
             */
            if(isLeapYear(this.yearI) && this.monthI < 2 || isLeapYear(other.yearI) && other.monthI > 2){
                days += 365;
                years = 1;
            }
            
            //looping throu each year and adding the number of days in them
            for(; years < other.yearI - this.yearI; years++){
                //cheking for leap year
                if(isLeapYear(other.yearI + years)){
                    days+= 366;
                }
                else{
                    days+=365;
                }
            }
            //when the first date falls on an eler month then the second date
            if(compairMonth(other) == -1){
                /*
                 * adding all the days of the months that are bwtwean
                 * this.dayI and other.dayI to sett the days counter to the number equivolent to
                 * the last day of the month emedeotly proseading the month that 
                 * contains other.dayI
                 */

                /*
                 * removing the days from the begining this.monthI to get to the
                 * last day of the preceading month
                 */
                days -= this.dayI;

                //adding the interveaning months days to the days count
                for(; months <= other.monthI - this.monthI; months++){
                    days += (other.daysInMonthIA[this.monthI + months - 1]);
                }

                /*
                 * adding the number of other.dayI to the days count 
                 * inorder to get from the end of the month befor to the corect date.
                 */
                days += other.dayI;
            }
            //when the dates have the same months
            else if(compairMonth(other) == 0){
                //seing whitch day is later in the month
                if(compairDay(other) == 1){
                    days -= (this.dayI - other.dayI);
                }
                else{
                    days += (other.dayI - this.dayI);
                }         
            }
            //when the staring date has a latter month then the other date
            else{
                /*
                 * removing all the days of the months that are bwtwean
                 * other.dayI and this.dayI to sett the days counter to the number equivolent to
                 * the last day of the month emedeotly proseading the month that 
                 * contains this.dayI
                 */

                /*
                 * removing the days from the begining of this.monthI to get to the
                 * last day of the preceading month
                 */
                days -= this.dayI;

                //removing the intervingin months days from the count of days
                for(; months <= this.monthI - other.monthI; months++){
                    days -= (other.daysInMonthIA[this.monthI - months - 1]);
                }

                /*
                 * adding the number of this.dayI to the days count 
                 *inorder to get from the end of the month befor to the corect date.
                 */
                days += other.dayI;
            }
        }
        return days;
    }

    /**
     * this changes the year of the date
     * 
     * @param  year  the new year you enterd
     * @return     void
     */
    public void setYear(int year)
    {
        if(checkDate(monthI, dayI, year)){
            yearI = year;
        }
    }

    /**
     * this returns what year is in the date
     * 
     * @param  void
     * @return     the year int he date class
     */
    public int getYear()
    {
        return yearI;
    }

    /**
     * this changes the month of the date
     * 
     * @param  month  the new month you enterd
     * @return     void
     */
    public void setMonth(int month)
    {
        if(checkDate(month, dayI, yearI)){
            monthI = month;
        }
    }

    /**
     * this changes the month of the date
     * 
     * @param  month  the new month you enterd
     * @return     void
     */
    public void setMonth(String monthName)
    {
        // changing the input month to the standerd format
        String changedMonthName = monthName.toLowerCase();
        changedMonthName.trim();
        //finding the location of the name of the month 
        int month = Arrays.asList(MONTH_NAME_SA).indexOf(changedMonthName) + 1;

        if(checkDate(month, dayI, yearI)){
            monthI = month;
        }
    }

    /**
     * this returns what month is in the date
     * 
     * @param  void
     * @return     the month in the date class
     */
    public int getMonth()
    {
        return monthI;
    }

    /**
     * this returns what month is in the date in word form
     * 
     * @param  void
     * @return     the month string in the date class
     */
    public String getMonthName()
    {
        return MONTH_NAME_SA[monthI - 1];
    }

    /**
     * this changes the day of the date
     * 
     * @param  day  the new year you enterd
     * @return     void
     */
    public void setDay(int day)
    {
        if(checkDate(monthI, dayI, yearI)){
            dayI = day;
        }
    }

    /**
     * this returns what day is in the date
     * 
     * @param  void
     * @return     the day in the date class
     */
    public int getDay()
    {
        return monthI;
    }

    /**
     * this compairs two date objects years to see whitch one is bigger.
     * 
     * @param  other  a difrent instence of the date class
     * @return     it reterns an int of -1,0,1 saying that the yeare of the curent object is
     *              less then, equal to , or grater then the input objects year
     */
    public int compairYear(Date other)
    {
        int answerI;
        //seing if this year is less then the other year
        if(this.yearI < other.yearI){
            answerI = -1;
        }
        //seing if this year is equal to the other year
        else if(this.yearI == other.yearI){
            answerI = 0;
        }
        //seing if this year is grater than the other year
        else 
        {
            answerI = 1;
        }

        return answerI;
    }

    /**
     * this compairs two date objects months to see whitch one is bigger.
     * 
     * @param  other  a difrent instence of the date class
     * @return     it reterns an int of -1,0,1 saying that the monthe of the curent object is
     *              less then, equal to , or grater then the input objects month
     */
    public int compairMonth(Date other)
    {
        int answerI;
        //seing if this month is less then the other month
        if(this.monthI < other.monthI){
            answerI = -1;
        }
        //seing if this month is equal to the other month
        else if(this.monthI == other.monthI){
            answerI = 0;
        }
        //seing if this month is grater than the other month
        else 
        {
            answerI = 1;
        }

        return answerI;
    }

    /**
     * this compairs two date objects days to see whitch one is bigger.
     * 
     * @param  other  a difrent instence of the date class
     * @return     it reterns an int of -1,0,1 saying that the daye of the curent object is
     *              less then, equal to , or grater then the input objects day
     */
    public int compairDay(Date other)
    {
        int answerI;
        //seing if this day is less then the other day
        if(this.dayI < other.dayI){
            answerI = -1;
        }
        //seing if this day is equal to the other day
        else if(this.dayI == other.dayI){
            answerI = 0;
        }
        //seing if this day is grater than the other day
        else 
        {
            answerI = 1;
        }

        return answerI;
    }

    /**
     * this is the equeals method for the date class
     * 
     * @param  other   a difrent instence of the date class
     * @return     void
     */
    public boolean equals(Date other)
    {
        return compairYear(other) == 0 && compairMonth(other) == 0 && compairDay(other) == 0;
    }

    /**
     * this determans if the new date object
     * 
     * @param  other  a difrent instence of the date class
     * @return     it reterns a posotive if the origonal is grater a negitive if smaller and a zero
     *              if they are the same;
     */
    public int compairTo(Date other)
    {
        //vareobles
        int resultI;

        //cheking if year is grater
        if(compairYear(other) == 1){
            resultI = 1;
        }
        //cheking if year is equal
        else if(compairYear(other) == 0){
            //cheking if month is grater
            if(compairMonth(other) == 1){
                resultI = 1;
            }
            //cheking if month is equal
            else if(compairMonth(other) == 0){
                //cheking if day is grater
                if(compairDay(other) == 1){
                    resultI = 1;
                }
                //cheking if day is equal
                else if(compairDay(other) == 0){
                    resultI = 0;
                }
                //if day is less
                else{
                    resultI = -1;
                }
            }
            //if month is less
            else{
                resultI = -1;
            }
        }
        //if year is less
        else{
            resultI = -1;
        }
        return resultI;
    }

    /**
     * this prints out the date in long form
     * 
     * @param  no paramiters
     * @return     it reterns a string consisting of the long form of the date
     */
    public String getLongDate()
    {
        return  MONTH_NAME_SA[monthI - 1] + " the " + dayI + " of " + yearI;
    }

    /**
     * this prints out the date in numerical form
     * 
     * @param  no paramiters
     * @return     it reterns a string consisting of the fealds in the class
     */
    public String toString()
    {
        return  monthI + "/" + dayI + "/" + yearI;
    }
}
