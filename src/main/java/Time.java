package main.java;

public class Time {
    private int weekDayCode;
    private int hour;
    private int minute;
    private static String[] weekdays = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public Time(int weekDayCode, int hour, int minute) throws IllegalArgumentException {
        if (weekDayCode < 0 || weekDayCode > 6) throw new IllegalArgumentException("0 for Saturday. 6 for Friday.");
        this.weekDayCode = weekDayCode;
        if (hour < 0 || hour > 24) throw new IllegalArgumentException("Invalid hour");
        this.hour = hour;
        if (minute < 0 || minute > 60) throw new IllegalArgumentException("Invalid minute");
        this.minute = minute;
    }

    public int compare(Time that) {
        if (this.weekDayCode < that.weekDayCode) return -1;
        if (this.weekDayCode > that.weekDayCode) return 1;
        if (this.hour < that.hour) return -1;
        if (this.hour > that.hour) return 1;
        return Integer.compare(this.minute, that.minute);
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getWeekDay() {
        return weekdays[weekDayCode];
    }

    public String toString() {
        return String.format("%s, %02d:%02d", this.getWeekDay(), hour, minute);
    }
}
