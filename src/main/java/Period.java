package main.java;

public class Period {
    private Time startTime;
    private Time endTime;

    public Period(Time start, Time end) {
        this.startTime = start;
        this.endTime = end;

    }

    public boolean coincides(Period that) {
        if (this.startTime.compare(that.endTime) == 1) return false;
        return !(this.endTime.compare(that.startTime) == -1);
    }

    public Time getStart() {
        return startTime;
    }

    public Time getEnd() {
        return endTime;
    }

    public String toString() {
        return String.format("From %s to %s.", startTime.toString(), endTime.toString());
    }
}
