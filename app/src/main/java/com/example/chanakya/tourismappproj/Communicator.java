package com.example.chanakya.tourismappproj;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by ryellap on 2/3/18.
 */

public class Communicator extends FragmentPagerAdapter {

    public Communicator(FragmentManager fm) {
        super(fm);
    }


    /*
    *
    * */
    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        //Initializing Fragments
        switch(position){
            case 0:
                return new Login();
            case 1:
                return new Register();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 1;
    }
}
