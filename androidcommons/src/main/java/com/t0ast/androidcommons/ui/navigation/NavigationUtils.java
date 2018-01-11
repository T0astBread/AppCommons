package com.t0ast.androidcommons.ui.navigation;

import android.app.Activity;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

/**
 * Created by T0astBread on 23.12.2017.
 */

public class NavigationUtils
{
    public static int indexOf(int menuItemId, Menu menu)
    {
        for(int i = 0; i < menu.size(); i++) if(menu.getItem(i).getItemId() == menuItemId) return i;
        return -1;
    }
}
