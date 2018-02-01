package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class ProfileFragment extends android.support.v4.app.Fragment {
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEditFirstName;
    private EditText mEditLastName;
    private Button mSubmitButton;
    private CheckBox mEssayCheckbox;
    private TextView mPersonalEssay;
    private TextView mHighSchool;
    private EditText mEditHighSchool;
    private EditText mACT;
    private EditText mSAT;
    private CheckBox mSATbox;
    private CheckBox mACTbox;
    private TextView mACTtext;
    private TextView mSATtext;

    private Profile mProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);
        View rootView = inflater.inflate(R.layout.fragment_profile, view, false);

        mFirstName = (TextView) rootView.findViewById(R.id.first_name_textview);
        mLastName = (TextView) rootView.findViewById(R.id.last_name_textview);

        mProfile = new Profile();

        mSubmitButton = (Button) rootView.findViewById(R.id.profile_submit_button);
        mEditFirstName = rootView.findViewById(R.id.edit_first_name);
        mEditLastName = rootView.findViewById(R.id.edit_last_name);

        mEssayCheckbox = (CheckBox) rootView.findViewById(R.id.personal_essay_checkbox);
        mPersonalEssay = (TextView) rootView.findViewById(R.id.personal_essay_textbox);


        mHighSchool = (TextView) rootView.findViewById(R.id.high_school_textbox);
        mEditHighSchool = (EditText) rootView.findViewById(R.id.high_school);

        mACT = (EditText) rootView.findViewById(R.id.act_edit_text);
        mSAT = (EditText) rootView.findViewById(R.id.sat_edit_text);
        mACTbox = (CheckBox) rootView.findViewById(R.id.act_checkbox);
        mSATbox = (CheckBox) rootView.findViewById(R.id.sat_checkbox);
        mACTtext = (TextView) rootView.findViewById(R.id.act_textbox);
        mSATtext = (TextView) rootView.findViewById(R.id.sat_textbox);



        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstName.setText("First Name: " + mEditFirstName.getText().toString());
                mLastName.setText("Last Name: " + mEditLastName.getText().toString());
                mHighSchool.setText("High School: " + mEditHighSchool.getText().toString());

                if (mEssayCheckbox.isChecked()) {
                    mPersonalEssay.setText("A personal Essay has been submitted.");
                } else if (!mEssayCheckbox.isChecked()) {
                    mPersonalEssay.setText("A personal Essay has not been submitted.");
                } else {
                    mPersonalEssay.setText("Your code is messed up.");
                }

                if (mACTbox.isChecked()) {
                    mACTtext.setText("ACT score: " + mACT.getText());
                } else if (!mACTbox.isChecked()) {
                    mACTtext.setText("No ACT scores avaliable.");
                } else {
                    mACTtext.setText("Your code is messed up.");
                }

                if (mSATbox.isChecked()) {
                    mSATtext.setText("SAT score: " + mSAT.getText());
                } else if (!mSATbox.isChecked()) {
                    mSATtext.setText("No SAT scores avaliable.");
                } else {
                    mSATtext.setText("Your code is messed up.");
                }


            }
        });

        mFirstName.setText(mProfile.getFirstName());
        mLastName.setText(mProfile.getLastName());




        return rootView;}
    }


