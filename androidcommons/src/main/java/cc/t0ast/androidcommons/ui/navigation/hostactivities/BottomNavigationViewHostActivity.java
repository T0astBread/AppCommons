package cc.t0ast.androidcommons.ui.navigation.hostactivities;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import cc.t0ast.androidcommons.ui.navigation.NavigationUtils;
import cc.t0ast.androidcommons.ui.navigation.pageradapters.MenuArrayFragmentStatePagerAdapter;

/**
 * Created by T0astBread on 23.12.2017.
 */

public class BottomNavigationViewHostActivity extends HostActivity
{
    protected ViewPager contentPager;
    protected MenuArrayFragmentStatePagerAdapter pagerAdapter;
    protected BottomNavigationView bottomNavigationView;

    public BottomNavigationViewHostActivity(Fragment... pages)
    {
        this.pagerAdapter = new MenuArrayFragmentStatePagerAdapter(getSupportFragmentManager());
        this.pagerAdapter.setPages(pages);
    }

    // region Initialization
    protected void initNavigation(int viewPagerId, int bottomNavigationViewId)
    {
        loadViews(viewPagerId, bottomNavigationViewId);
        this.pagerAdapter.setMenu(this.bottomNavigationView.getMenu());
        attachBehaviour();
    }

    private void loadViews(int viewPagerId, int bottomNavigationViewId)
    {
        this.contentPager = findViewById(viewPagerId);
        this.bottomNavigationView = findViewById(bottomNavigationViewId);
    }

    private void attachBehaviour()
    {
        this.contentPager.setAdapter(this.pagerAdapter);
        this.contentPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                bottomNavigationView.setSelectedItemId(bottomNavigationView.getMenu().getItem(position).getItemId());
            }
        });

        this.bottomNavigationView.setOnNavigationItemSelectedListener(item ->
        {
            this.contentPager.setCurrentItem(NavigationUtils.indexOf(item.getItemId(), this.bottomNavigationView.getMenu()), true);
            return true;
        });
    }
    // endregion

    public void setPages(Fragment... pages)
    {
        this.pagerAdapter.setPages(pages);
    }

    public Fragment getPage(int index)
    {
        return this.pagerAdapter.getItem(index);
    }
}
