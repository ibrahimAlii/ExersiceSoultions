package IntroductionToJavaProgramming.chapter5_methods;

public class CurrentDateAndTime {

    private static final int OFFSET_TIME = 2;

    public static void getCurrentDateAndTime(){


        System.out.println("Current date and time is: " +
                currentMonth(month()) + " " + day() +", " + year() + " "+ displayTime());

    }

    private static int getCurrentDay(int year, int month) {
        int total = 0;

        for (int i = 1800; i < year; i++)
            if (isLeapYear(i))
                total += 366;
            else
                total += 365;


        for (int i = 1; i < month; i++)
            total = getNumberOfDays(year, i);


        return currentDay() - total;
    }

    private static int getNumberOfDays(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12)
            return 31;
        if (month == 4 || month == 6 || month == 9 || month == 11)
            return 30;
        if (month == 2) return isLeapYear(year) ? 29 : 28;

        else return 0;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 400 != 0);
    }


    private static int day() {
        return getCurrentDay(year(), month());
    }


    private static int month() {
        return (int) ((System.currentTimeMillis() % millisecondPerYear()) / millisecondsPerMonth()) + 1;
    }

    private static int year() {
        return (int) (System.currentTimeMillis() / millisecondPerYear()) + 1970;
    }

    private static int currentDay(){
        return (int) (System.currentTimeMillis() / millisecondPerYear());
    }

    private static String currentMonth(int month){
        String currentMonth = "";
        switch (month) {
            case 1:
                currentMonth = "Jan";
                break;
            case 2:
                currentMonth = "Feb";
                break;
            case 3:
                currentMonth = "Mar";
                break;
            case 4:
                currentMonth = "Apr";
                break;
            case 5:
                currentMonth = "May";
                break;
            case 6:
                currentMonth = "Jun";
                break;
            case 7:
                currentMonth = "Jul";
                break;
            case 8:
                currentMonth = "Aug";
                break;
            case 9:
                currentMonth ="Sep";
                break;
            case 10:
                currentMonth = "Oct";
                break;
            case 11:
                currentMonth ="Nov";
                break;
            case 12:
                currentMonth = "Dec";
                break;

        }
        return currentMonth;
    }

    /** Method millisecondPerYear */
    public static double millisecondPerYear() {
        return 3.15569E10;
    }
    /** Method millisecondsPerMonth */
    public static double millisecondsPerMonth() {
        return 2.63E9;
    }

    private static String displayTime() {
        long totalTime = System.currentTimeMillis();

        totalTime /= 1000; //get all second since Jan 1, 1970.

        //getting current minutes and seconds
        String currentMinutesAndSeconds = "";
        for (int i = 0; i < 2; i++) {
            currentMinutesAndSeconds =
                    (totalTime % 60 < 10 ? ":0" + totalTime % 60 : ":" + totalTime % 60) + currentMinutesAndSeconds;
            totalTime /= 60;
        }
        String pmOrAm = "";
        long currentHour =  totalTime % 24;

        if (currentHour == 0){
            currentHour = 24;
        }

        if (currentHour > 12){
            currentHour -= 12;
            pmOrAm = "PM";
        }else
            pmOrAm = "AM";

        currentHour += OFFSET_TIME;

        return currentHour  + currentMinutesAndSeconds + pmOrAm;
    }
}
