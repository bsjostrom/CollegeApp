package org.pltw.examples.collegeapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.backendless.Backendless;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.exceptions.BackendlessFault;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class ProfileFragment extends android.support.v4.app.Fragment{

    public final String TAG = this.getClass().getName();
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

                SharedPreferences sharedPreferences =
                        getActivity().getPreferences(Context.MODE_PRIVATE);
                String email = sharedPreferences.getString(ApplicantActivity.EMAIL_PREF, null);
                if (mProfile.getEmail() == null) {
                    mProfile.setEmail(email);
                }
                String whereClause = "email = '" + email + "'";
                DataQueryBuilder query = DataQueryBuilder.create();
                query.setWhereClause(whereClause);
                Backendless.Data.of(Profile.class).find(query, new AsyncCallback<List<Profile>>() {
                    @Override
                    public void handleResponse(List<Profile> profile) {
                        if (!profile.isEmpty()) {
                            //String profileId = profile.get(0).getObjectId();
                            //Log.d(TAG, "Object ID: " + profileId);
                           // mProfile.setObjectId(profileId);
                        }
                    }
                    @Override
                    public void handleFault(BackendlessFault fault) {
                        Log.e(TAG, "Failed to find profile: " + fault.getMessage());
                    }
                });
                Backendless.Data.of(Profile.class).save(mProfile, new AsyncCallback<Profile>() {
                    @Override
                    public void handleResponse(Profile response) {
                        Log.i(TAG, "Saved profile to Backendless");
                    }
                    public void handleFault(BackendlessFault fault) {
                        Log.i(TAG, "Failed to save profile!" + fault.getMessage());
                    }
                });
            }
        });

        mFirstName.setText(mProfile.getFirstName());
        mLastName.setText(mProfile.getLastName());

        return rootView;
    }

    //@Override
    public void OnStart() {
     super.onStart();
    }
}
