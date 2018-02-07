package org.pltw.examples.collegeapp;

import android.widget.CheckBox;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class Profile extends ApplicantData {
    private String firstName;
    private String lastName;


    private CheckBox PersonalEssayCheckbox;


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

    public Profile() {
        firstName = "Alan";
        lastName = "Turing";
    }






}


