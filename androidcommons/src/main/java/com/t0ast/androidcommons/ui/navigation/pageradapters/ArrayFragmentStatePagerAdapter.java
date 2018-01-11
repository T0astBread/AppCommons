package com.t0ast.androidcommons.ui.navigation.pageradapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.Arrays;
import java.util.List;

/**
 * Created by T0astBread on 23.12.2017.
 */

public abstract class ArrayFragmentStatePagerAdapter extends FragmentStatePagerAdapter
{
    private List<Fragment> pages;

    public ArrayFragmentStatePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public ArrayFragmentStatePagerAdapter setPages(Fragment... pages)
    {
        return setPages(Arrays.asList(pages));
    }

    public ArrayFragmentStatePagerAdapter setPages(List<Fragment> fragments)
    {
        this.pages = fragments;
        notifyDataSetChanged();
        return this;
    }

    @Override
    public Fragment getItem(int position)
    {
        return this.pages.get(position);
    }

    @Override
    public int getCount()
    {
        return this.pages.size();
    }
}
