package com.example.adu49.autoslider;

import android.content.Context;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;


public class InfinitePagerAdapter extends PagerAdapter {

    private PagerAdapter adapter;
    public InfinitePagerAdapter(PagerAdapter adapter) {
        this.adapter = adapter;
    }



    @Override
    public int getCount() {
        if (getRealCount() == 0) {
            return 0;
        }
        // warning: scrolling to very high values (1,000,000+) results in
        // strange drawing behaviour
        return Integer.MAX_VALUE;
    }
    public int getRealCount() {
        return adapter.getCount();
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        int virtualPosition = position % getRealCount();
        // only expose virtual position to the inner adapter
        return adapter.instantiateItem(container, virtualPosition);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        int virtualPosition = position % getRealCount();
        // only expose virtual position to the inner adapter
        adapter.destroyItem(container, virtualPosition, object);
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
        return adapter.isViewFromObject(view, object);
    }



}

