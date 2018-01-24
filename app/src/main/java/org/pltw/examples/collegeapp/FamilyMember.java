package org.pltw.examples.collegeapp;

/**
 * Created by 20sjobai on 1/24/2018.
 */

public class FamilyMember {

    private String lastName;
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public FamilyMember() {
        firstName = "Ada";
        lastName = "Lovelace";
    }
}
