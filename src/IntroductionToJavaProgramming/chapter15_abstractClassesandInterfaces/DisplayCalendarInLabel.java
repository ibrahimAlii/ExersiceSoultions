package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import IntroductionToJavaProgramming.chapter13_graphics.MessagePanel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormatSymbols;
import java.util.Date;
import java.util.GregorianCalendar;

public class DisplayCalendarInLabel extends JFrame{


    /**
     * Constructor for current date.
     *
     */
    public DisplayCalendarInLabel() {
        this(new GregorianCalendar());
    }

    /**
     * Constructor for specific date.
     *
     */
    DisplayCalendarInLabel(int year, int month, int day) {
        this(new GregorianCalendar(year, month, day));
    }

    /**
     * Assemble a CalendarWindow object for the month the given
     * GregorianCalendar object specifies.
     *
     */
    DisplayCalendarInLabel(GregorianCalendar date) {
        this.setLayout(new BorderLayout(5,5));
        this.setSize(300,240);

        // retrieve symbols for day and month names
        // side effect: script is locale ready assuming arabic numerals
        DateFormatSymbols symbols = new DateFormatSymbols();
        String[] weekday_symbols = symbols.getWeekdays();
        String[] month_symbols = symbols.getMonths();

        // set the title to something useful
        this.setTitle(String.format(
                "%s %s %01d, %d",
                weekday_symbols[date.get(date.DAY_OF_WEEK)],
                month_symbols[date.get(date.MONTH)],
                date.get(date.DATE),
                date.get(date.YEAR)));

        JPanel weekday_labels = new JPanel(new GridLayout(0,7,5,5));

        // populate the weekday names row
        for(int i = 1; i < weekday_symbols.length; i++) {
            JLabel weekday = new JLabel(weekday_symbols[i]);
            weekday.setHorizontalAlignment(JLabel.CENTER);
            weekday.setVerticalAlignment(JLabel.BOTTOM);
            weekday_labels.add(weekday);
        }

        JPanel day_grid = new JPanel(new GridLayout(0,7,5,5));

        // retrieve the weekday identifier for the first of the month.
        // why there isn't a function that grabs this vital information
        // I do not know.
        int first = new GregorianCalendar(date.get(date.YEAR),
                date.get(date.MONTH), 1).get(date.DAY_OF_WEEK);

        // retrieve the days in the month
        // The ACTUAL maximum because I really want the length of
        // the month, and not the maximum value the field holds.
        //
        // for the future: how about getMaximum(DAY_OF_MONTH) for
        // length of month and getMaximumValue(DAY_OF_MONTH) for
        // the maximum value the field supports.
        int days_in_month = date.getActualMaximum(date.DAY_OF_MONTH);

        // populate the day of month grid
        // loops from 1 to the number of days in the month, plus an
        // offset some for the weekday offset.
        for (int i = 1; i < days_in_month+first; i++) {
            // offset the labels so the first fall on the correct
            // weekday
            if(i-first+1 > 0) {
                JLabel day;
                day = new JLabel(""+(i-first+1));

                if(i-first+1 == date.get(date.DAY_OF_MONTH)) {
                    day.setForeground(Color.RED);
                }

                day.setHorizontalAlignment(JLabel.CENTER);
                day_grid.add(day);
            } else {
                // placeholder, since you can't skip cells.
                JPanel empty = new JPanel();
                day_grid.add(empty);
            }
        }

        // Add everything to the window. All two of them.
        // weekdays on a border because those collapse, days in center
        // because it expands.
        this.add(weekday_labels, BorderLayout.NORTH);
        this.add(day_grid, BorderLayout.CENTER);
    }



}
