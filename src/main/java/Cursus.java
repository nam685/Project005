package main.java;

import java.util.ArrayList;

public class Cursus {
    private ArrayList<UE> ueList;
    private String name;

    public Cursus(String name) {
        this.name = name;
        this.ueList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<UE> getUEs() {
        return ueList;
    }

    public void addUE(UE ue) {
        this.ueList.add(ue);
    }
}
