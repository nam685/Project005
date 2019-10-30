package main.java;

import java.util.ArrayList;

public abstract class Member {
    String name;
    String login;
    String password;
    ArrayList<Period> timeTable;

    public Member(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.timeTable = new ArrayList<>();
    }

    public void addPeriod(Period p) {
        timeTable.add(p);
    }

    public ArrayList<Period> getTimeTable() {
        return timeTable;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
