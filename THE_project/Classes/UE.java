//package main.java;

import java.util.ArrayList;

public class UE {

    private String name;
    private static final int MAX_GROUPS = 8;
    private Group[] groupList;
    private int nbGroups;
    private String website;
    private String reference;
    private int etcs;
    private static ArrayList<String> referenceList = new ArrayList<>();

    private UE(String name, String website, String reference,int etcs) throws IllegalArgumentException {
        if (referenceList.contains(reference))
            throw new IllegalArgumentException("Reference taken.");
        this.name = name;
        this.etcs=etcs;
        this.website = website;
        this.reference = reference;
        this.groupList = new Group[MAX_GROUPS];
        this.nbGroups = 0;
        referenceList.add(reference);
    }

    public static UE createUE(String name, String website, String reference,int etcs) {
        try {
            return new UE(name, website, reference, etcs);
        } catch (IllegalArgumentException e) {
            System.out.println(e.toString() + " UE instance not created.");
            for (StackTraceElement s : e.getStackTrace()) System.out.println(s.toString());
            return null;
        }
    }

    public String getName() {
        return name;
    }

    public void createGroup(Class class1, Class class2, Class class3) {
        if (this.nbGroups >= MAX_GROUPS || this.nbGroups < 0) return;
        Group tmp = new Group(nbGroups + 1);
        tmp.addClass(class1);
        tmp.addClass(class2);
        tmp.addClass(class3);
        this.groupList[nbGroups++] = tmp;
    }

    public Group[] getGroupList() {
        return groupList;
    }

    public Group getGroupByGroupNumber(int groupNumber) {
        for (Group g : groupList) {
            if (g != null && g.getGroupNumber() == groupNumber) return g;
        }
        return null;
    }

    public String getWebsite() {
        return website;
    }

    public String getReference() {
        return reference;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("UE: ").append(getName()).append(". Reference: ").append(reference).append(". Groups: \n");
        for (int i = 0; i < nbGroups; i++) {
            s.append(groupList[i].toString());
        }
        return s.toString();
    }

    public String toStringUES(){
        StringBuilder s = new StringBuilder();
        s.append(getReference()).append("\t"+getName()+"\t ( "+etcs+" )\n");
        return s.toString();

    }
}
