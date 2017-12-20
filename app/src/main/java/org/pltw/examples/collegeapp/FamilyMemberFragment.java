package org.pltw.examples.collegeapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by 20sjobai on 12/20/2017.
 */

public class FamilyMemberFragment extends android.support.v4.app.Fragment {
    @Override
   public View onCreateView(LayoutInflater inflater, ViewGroup view, Bundle bundle) {
       super.onCreateView(inflater, view, bundle);
       View rootView = inflater.inflate(R.layout.fragment_family_member, view, false);
       return rootView;
    }
}
