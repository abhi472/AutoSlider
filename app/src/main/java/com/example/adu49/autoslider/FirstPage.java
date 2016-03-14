package com.example.adu49.autoslider;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import com.example.adu49.autoslider.CustomPageAdapter;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewFlipper;

import java.util.Timer;
import java.util.TimerTask;

public class FirstPage extends AppCompatActivity {

    int i=0;
    Timer swipeTimer=new Timer();
    Runnable Update;
     int currentPage;
    CustomViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        int[] mResources = {
                R.drawable.background,
                R.drawable.second,
                R.drawable.third,
                R.drawable.fourth,
                R.drawable.fifth,
                R.drawable.sixth
        };
        setContentView(R.layout.activity_first_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.mToolbar);
        setSupportActionBar(toolbar);
        PagerAdapter cpa = new InfinitePagerAdapter(new CustomPageAdapter(this,mResources));
        viewPager=(CustomViewPager)findViewById(R.id.tab_viewpager);
        viewPager.setAdapter(cpa);
        currentPage=viewPager.getCurrentItem();
//         final Handler handler = new Handler();
//        Update = new Runnable() {
//            public void run() {
//                    viewPager.setCurrentItem(currentPage++, true);
//
//
//
//
//            }
//        };
//        swipeTimer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//
//                handler.post(Update);
//            }
//        }, 500, 3000);




         }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
