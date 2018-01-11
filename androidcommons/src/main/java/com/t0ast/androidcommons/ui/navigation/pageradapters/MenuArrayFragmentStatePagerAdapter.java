package com.t0ast.androidcommons.ui.navigation.pageradapters;

import android.support.v4.app.FragmentManager;
import android.view.Menu;

/**
 * Created by T0astBread on 23.12.2017.
 */

public class MenuArrayFragmentStatePagerAdapter extends ArrayFragmentStatePagerAdapter
{
    private Menu menu;

    public MenuArrayFragmentStatePagerAdapter(FragmentManager fm)
    {
        super(fm);
    }

    public Menu getMenu()
    {
        return this.menu;
    }

    public void setMenu(Menu menu)
    {
        this.menu = menu;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return menu.getItem(position).getTitle().toString();
    }
}
