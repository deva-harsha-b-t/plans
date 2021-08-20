package com.dojo.basics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    private CircleImageView imageView;
    private viewPagerAdapter adapter;
    private ViewPager2 viewPager2;
    private List<plan> plans;
    private TextView[] dots;
    private LinearLayout dotsLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dotsLayout = findViewById(R.id.dotsLayout);
        fillPlans();
        viewPager2 = findViewById(R.id.viewpager);
        adapter = new viewPagerAdapter(this,plans);
        viewPager2.setAdapter(adapter);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                for(int i=0;i<dots.length;i++){
                    if(i == position){
                        dots[i].setTextColor(getColor(R.color.black));
                    }else {
                        dots[i].setTextColor(getColor(R.color.light_black));
                    }
                }
                super.onPageSelected(position);
            }
        });

    }

    private void fillPlans() {
        plans = new ArrayList<>();
        plans.add(new plan("No condition for 15 days*","free trail","₹0/",R.drawable.trial_ic,true,true));
        plans.add(new plan("Idle for small studios","Starter Plan","₹999/",R.drawable.starter_ic,true,true));
        plans.add(new plan("Idle for Large studios","Essential Plan","₹1999/",R.drawable.essential_ic,false,false));
        plans.add(new plan("A complete solution","premium","₹2499/",R.drawable.premium_ic,true,true));
        dots = new TextView[plans.size()];
        for(int i=0;i<dots.length;i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#9679;"));
            dots[i].setTextSize(18);
            dotsLayout.addView(dots[i]);
        }

    }
}