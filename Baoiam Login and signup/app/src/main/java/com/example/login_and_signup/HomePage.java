package com.example.login_and_signup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.ramotion.circlemenu.CircleMenuView;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {
    ImageView live_classes, new_courses, menu_a, menu_b, search_a, bookmark_a, profile_a, menu_1;
    TextView demo, prof_course, free_trial, internship_training;
    ViewPager mViewPager;
    private LinearLayout pager_indicator;
    ImageView image1, image2;
    private SharedPreferenceConfig preferenceConfig;
    private int dotsCount;
    private ImageView[] dots;
    final CircleMenuView menu = findViewById(R.id.circle_menu);


    int[] images = {R.drawable.c5, R.drawable.c4, R.drawable.c6};
    int[] imageUrl = {R.drawable.c2, R.drawable.c1, R.drawable.c3};


    ViewPagerAdapter mViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        ArrayList<SliderData> sliderDataArrayList = new ArrayList<>();


        demo = findViewById(R.id.demo);
        prof_course = findViewById(R.id.professional_course);
        free_trial = findViewById(R.id.free_trial);
        internship_training = findViewById(R.id.internship_course);
        live_classes = findViewById(R.id.live_classes);
        // new_courses = findViewById(R.id.n);
        //menu_a = findViewById(R.id.menu_a);
        menu_1 = findViewById(R.id.menu1);
        search_a = findViewById(R.id.search1);
        bookmark_a = findViewById(R.id.bookmark1);
        profile_a = findViewById(R.id.profile1);
        search_a = findViewById(R.id.search1);

        mViewPager = (ViewPager) findViewById(R.id.viewPagerMain);

        // Initializing the ViewPagerAdapter
        mViewPagerAdapter = new ViewPagerAdapter(HomePage.this, images);

        pager_indicator = (LinearLayout) findViewById(R.id.viewPagerCountDots);

        // Adding the Adapter to the ViewPager
        mViewPager.setAdapter(mViewPagerAdapter);

        // initializing the slider view.
        SliderView sliderView = findViewById(R.id.slider);

        // adding the urls inside array list
        for (int i = 0; i < imageUrl.length; i++) {
            SliderData item = new SliderData();
            item.setImgUrl(imageUrl[i]);
            // item.setTitle(getResources().getString(header[i]));
            //  item.setDescription(getResources().getString(desc[i]));

            sliderDataArrayList.add(item);
        }


        // passing this array list inside our adapter class.
        SliderAdapter adapter = new SliderAdapter(this, sliderDataArrayList);

        // below method is used to set auto cycle direction in left to
        // right direction you can change according to requirement.
        sliderView.setAutoCycleDirection(SliderView.LAYOUT_DIRECTION_LTR);

        // below method is used to
        // setadapter to sliderview.
        sliderView.setSliderAdapter(adapter);

        // below method is use to set
        // scroll time in seconds.
        sliderView.setScrollTimeInSec(5);

        // to set it scrollable automatically
        // we use below method.
        sliderView.setAutoCycle(true);

        // to start autocycle below method is used.
        sliderView.startAutoCycle();



      /*  public void CekSession(){

            Boolean Check = Boolean.valueOf(SharedPrefs.readSharedSetting(HomePage.this, "CaptainCode", "true"));

            Intent introIntent = new Intent(HomePage.this, Login.class);
            introIntent.putExtra("CaptainCode", Check);

            //The Value if you click on Login Activity and Set the value is FALSE and whe false the activity will be visible
            if (Check) {
                startActivity(introIntent);
                finish();
            } //If no the Main Activity not Do Anything
        }*/


        demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), DemoSession.class));

            }
        });


        prof_course.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), ProfessionalCourses.class));

            }
        });

        free_trial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), FreeTrial.class));

            }
        });

/*
        new_courses.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity( new Intent(getApplicationContext(), NewCourses.class));

            }
        });

        */

        internship_training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), InternshipTrainings.class));

            }
        });

        live_classes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), LiveClasses.class));

            }
        });

        bookmark_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), BookMark.class));

            }
        });

        profile_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                FirebaseAuth.getInstance().signOut();
                preferenceConfig.writeloginStatus(false);
                startActivity(new Intent(getApplicationContext(), Signup.class));
                finish();


            }
        });

        demo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), DemoSession.class));

            }

        });

        menu_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.


                //And when you click on Logout button, You will set the value to True AGAIN
                startActivity(new Intent(getApplicationContext(), DemoSession.class));
                finish();
            }
        });


        search_a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // opening a new intent to open settings activity.
                startActivity(new Intent(getApplicationContext(), DemoSession.class));

            }
        });


        menu.setEventListener(new CircleMenuView.EventListener(){
            @Override
            public void onMenuOpenAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationStart");
            }
            @Override
            public void onMenuOpenAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuOpenAnimationEnd");
            }
            @Override
            public void onMenuCloseAnimationStart(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationStart");
            }
            @Override
            public void onMenuCloseAnimationEnd(@NonNull CircleMenuView view) {
                Log.d("D","onMenuCloseAnimationEnd");
            }
            @Override
            public void onButtonClickAnimationStart(@NonNull CircleMenuView view, int index) {
                Log.d("D","onButtonClickAnimationStart|index: "+index);
            }
            @Override
            public void onButtonClickAnimationEnd(@NonNull CircleMenuView view, int index) {
                Log.d("D","onButtonClickAnimationEnd|index: "+index);
            }
            @Override
            public boolean onButtonLongClick(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClick|index: "+buttonIndex);
                return true;
            }
            @Override
            public void onButtonLongClickAnimationStart(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClickAnimationStart|index: "+buttonIndex);
            }
            @Override
            public void onButtonLongClickAnimationEnd(@NonNull CircleMenuView view, int buttonIndex) {
                Log.d("D","onButtonLongClickAnimationEnd|index: "+buttonIndex);
            }
        });



    }


        private void setUiPageViewController (){

            dotsCount = images.length;
            dots = new ImageView[dotsCount];

            for (int i = 0; i < images.length; i++) {
                dots[i] = new ImageView(this);
                dots[i].setImageDrawable(ContextCompat.getDrawable(HomePage.this, R.drawable.non_selected_item_dot));

                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );

                params.setMargins(6, 0, 6, 0);

                pager_indicator.addView(dots[i], params);
            }

            dots[0].setImageDrawable(ContextCompat.getDrawable(HomePage.this, R.drawable.selected_item_dot));
        }


}