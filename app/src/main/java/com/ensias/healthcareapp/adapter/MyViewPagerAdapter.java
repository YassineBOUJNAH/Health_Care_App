package com.ensias.healthcareapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ensias.healthcareapp.fragment.BookingStep1Fragment;
import com.ensias.healthcareapp.fragment.BookingStep2Fragment;
import com.ensias.healthcareapp.fragment.BookingStep3Fragment;

public class MyViewPagerAdapter extends FragmentPagerAdapter {



    public MyViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position){
            case 0:
                return BookingStep1Fragment.getInstance();
            case 1:
                return BookingStep2Fragment.getInstance();
            case 2:
                return BookingStep3Fragment.getInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
