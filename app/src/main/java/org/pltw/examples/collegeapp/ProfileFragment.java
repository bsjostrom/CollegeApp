package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class ProfileFragment extends android.support.v4.app.Fragment{
    private TextView mFirstName;
    private TextView mLastName;
    private EditText mEditFirstName;
    private EditText mEditLastName;
    private Button mSubmitButton;

    private Profile mProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
        super.onCreateView(inflater, view, bundle);
        View rootView = inflater.inflate(R.layout.fragment_profile, view, false);

        mFirstName = (TextView) rootView.findViewById(R.id.first_name_textview);
        mLastName =  (TextView) rootView.findViewById(R.id.last_name_textview);

        mProfile = new Profile();

        mSubmitButton = (Button) rootView.findViewById(R.id.profile_submit_button);
        mEditFirstName = rootView.findViewById(R.id.edit_first_name);
        mEditLastName = rootView.findViewById(R.id.edit_last_name);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mFirstName.setText(mEditFirstName.getText().toString());
                mLastName.setText(mEditLastName.getText().toString());
            }
        });

        mFirstName.setText(mProfile.getFirstName());
        mLastName.setText(mProfile.getLastName());

        return rootView;
    }
}
