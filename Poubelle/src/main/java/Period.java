package main.java;

public class Period {
    private Time startTime;
    private Time endTime;

    private Period(Time start, Time end) throws IllegalArgumentException {
        if (start == null || end == null) throw new IllegalArgumentException("You passed me a null Time instance");
        if (start.compare(end) != -1) throw new IllegalArgumentException("Period must start before it ends!");
        this.startTime = start;
        this.endTime = end;
    }

    public static Period createPeriod(Time start, Time end) {
        try {
            return new Period(start, end);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + ". Period instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
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

    @Override
	public String toString() {
        return String.format("From %s to %s.", startTime.toString(), endTime.toString());
    }
}
