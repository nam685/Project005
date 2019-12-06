//package main.java;

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

    public UE getUEByReference(String reference) {
        for (UE ue : ueList) {
            if (ue.getReference().equals(reference)) return ue;
        }
        return null;
    }

    public void addUE(UE ue) {
        this.ueList.add(ue);
    }

    @Override
	public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(">>Cursus: ").append(getName()).append("<<").append("\n>>Liste des UEs:\n");
        s.append("-Reference-\t-Name-\t\t\t-Credit-\n");
        for (UE ue : ueList) {
            s.append(ue.toStringUES());
        }
        return s.toString();
    }

}
