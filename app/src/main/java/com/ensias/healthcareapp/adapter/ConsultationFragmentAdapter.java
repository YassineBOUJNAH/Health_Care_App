package com.ensias.healthcareapp.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ensias.healthcareapp.fragment.ConsultationFragment;

public class ConsultationFragmentAdapter extends FragmentPagerAdapter {
    // 1 - Array of colors that will be passed to PageFragment
    private int[] colors;

    // 2 - Default Constructor
    public ConsultationFragmentAdapter(FragmentManager mgr, int[] colors) {
        super(mgr);
        this.colors = colors;
    }

    @Override
    public int getCount() {
        return(5); // 3 - Number of page to show
    }

    @Override
    public Fragment getItem(int position) {
        // 4 - Page to return
        return(ConsultationFragment.newInstance(position, this.colors[position]));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "Page "+position;
    }
}
