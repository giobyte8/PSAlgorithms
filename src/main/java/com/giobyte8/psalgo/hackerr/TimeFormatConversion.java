package com.giobyte8.psalgo.hackerr;

/**
 * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
 * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
 * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
 * <br/>
 * Example 1:
 * Input: '12:01:00PM
 * Return: '12:01:00'.
 * <br/>
 * Example 2:
 * Input: '12:01:00AM'
 * Return '00:01:00'.
 * <br/>
 * Constraints
 * All input times are valid
 */
public class TimeFormatConversion {

    public static String timeConversion(String s) {
        String amPm = s.substring(8);
        String hour = s.split(":")[0];

        int intHour = Integer.parseInt(hour);

        // 12am becomes 00
        if (intHour == 12 && amPm.equals("AM")) {
            intHour = 0;
        }

        // 1pm -> 11pm becomes hour + 12
        else if (intHour != 12 && amPm.equals("PM")) {
            intHour += 12;
        }

        return String.format("%02d%s", intHour, s.substring(2, 8));
    }
}
