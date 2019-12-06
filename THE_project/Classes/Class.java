//package main.java;

public class Class {
    private Period period;
    private Teacher teacher;
    private String room;
    private String type;

    private Class(Period period, Teacher teacher, String room, String type) throws RuntimeException {
        this.period = period;
        this.room = room;
        for (Period p : teacher.getTimeTable()) {
            if (p.coincides(period)) throw new RuntimeException("Teacher busy.");
        }
        this.teacher = teacher;
        this.type = "Cours";
        teacher.addPeriod(period);
        if (type.equals("TD") || type.equals("TME")) this.type = type;
    }

    public static Class createClass(Period period, Teacher teacher, String room, String type) {
        try {
            return new Class(period, teacher, room, type);
        } catch (RuntimeException e) {
            System.out.println(e.toString() + " Class instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public Period getPeriod() {
        return period;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public String getRoom() {
        return room;
    }

    public String getType() {
        return type;
    }

    @Override
	public String toString() {
        return String.format("Teacher %s. %s Room: %s. Type: %s", teacher.getName(), period.toString(), room, type);
    }
}
