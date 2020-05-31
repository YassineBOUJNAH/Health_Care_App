package com.ensias.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.ensias.healthcareapp.Common.Common;
import com.ensias.healthcareapp.Common.NonSwipeViewPager;
import com.ensias.healthcareapp.adapter.MyViewPagerAdapter;
import com.shuhart.stepview.StepView;

import java.util.ArrayList;
import java.util.List;

import static com.ensias.healthcareapp.fragment.BookingStep1Fragment.spinner;

public class TestActivity extends AppCompatActivity {

    StepView stepView;
    NonSwipeViewPager viewPager;
    Button btn_previous_step;
    Button btn_next_step;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        stepView = findViewById(R.id.step_view);
        viewPager = findViewById(R.id.view_pager);
        btn_next_step  = findViewById(R.id.btn_next_step);
        btn_previous_step = findViewById(R.id.btn_previous_step);

        setupStepView();
        setColorButton();

        viewPager.setAdapter(new MyViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setOffscreenPageLimit(2);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setColorButton();

            }

            @Override
            public void onPageSelected(int position) {
                stepView.go(position,true);
                if( position == 0)
                    btn_previous_step.setEnabled(false);
                else
                    btn_previous_step.setEnabled(true);
                if(position == 2)
                    btn_next_step.setEnabled(false);
                else
                    btn_next_step.setEnabled(true);


                setColorButton();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        btn_next_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Common.step < 3 || Common.step == 0 ){
                    Common.step++ ;
                    viewPager.setCurrentItem(Common.step);
                    Common.CurreentDoctor=spinner.getSelectedItem().toString();
                    Log.e("Spinnr", Common.CurreentDoctor);
                }
            }
        });
        btn_previous_step.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Common.step == 3 || Common.step > 0 ){
                    Common.step-- ;
                    viewPager.setCurrentItem(Common.step);
                }
            }
        });

        loadTimeSlotOfDoctor("testdoc@testdoc.com");
    }

    private void loadTimeSlotOfDoctor(String doctorId) {
        Intent intent = new Intent(Common.KEY_DISPLAY_TIME_SLOT);
        //LocalBroadcastManager.sendBroadcast(intent);
    }

    private void setColorButton() {
        if(btn_previous_step.isEnabled()){
            btn_previous_step.setBackgroundResource(R.color.design_default_color_primary_dark);
        }
        else{
            btn_previous_step.setBackgroundResource(R.color.colorAccent);
        }
        if(btn_next_step.isEnabled()){
            btn_next_step.setBackgroundResource(R.color.design_default_color_primary_dark);
        }
        else{
            btn_next_step.setBackgroundResource(R.color.colorAccent);
        }
    }

    private void setupStepView() {
        List<String> stepList = new ArrayList<>();
        stepList.add("Time");
        stepList.add("Confirm");
        stepList.add("finish");
        stepView.setSteps(stepList);

    }

}
