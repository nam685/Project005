package main.java;

import java.util.ArrayList;

public class UE {
    private String name;
    private static final int MAX_GROUPS = 8;
    private Group[] groupList;
    private int nbGroups;
    private String website;
    private String reference;
    //guarantees references' uniqueness
    private static ArrayList<String> referenceList = new ArrayList<>();

    public UE(String name, String website, String reference) throws IllegalArgumentException {
        if (referenceList.contains(reference))
            throw new IllegalArgumentException("Reference taken.");
        this.name = name;
        this.website = website;
        this.reference = reference;
        this.groupList = new Group[MAX_GROUPS];
        this.nbGroups = 0;
        referenceList.add(reference);
    }

    public void createGroup(Class class1,
                            Class class2, Class class3) {
        if (this.nbGroups == 8) return;
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
            if (g.getGroupNumber() == groupNumber) return g;
        }
        return null;
    }

    public String getWebsite() {
        return website;
    }

    public String getReference() {
        return reference;
    }
}
