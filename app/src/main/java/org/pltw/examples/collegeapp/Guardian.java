package org.pltw.examples.collegeapp;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class Guardian extends FamilyMember{
    private String firstName;
    private String lastName;

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

    public Guardian() {
        firstName = "Grace";
        lastName = "Hopper";
    }


}
