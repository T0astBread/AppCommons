package cc.t0ast.androidcommons.ui.navigation.hostactivities;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import cc.t0ast.androidcommons.ui.navigation.pageradapters.ArrayFragmentStatePagerAdapter;

/**
 * Created by T0astBread on 07.02.2018.
 */

public class TabHostActivity extends HostActivity
{
    private ViewPager contentPager;
    private ArrayFragmentStatePagerAdapter pagerAdapter;
    private TabLayout tabLayout;

    public TabHostActivity(Fragment... pages)
    {
        this.pagerAdapter = new ArrayFragmentStatePagerAdapter(getSupportFragmentManager());
        this.pagerAdapter.setPages(pages);
    }

    // region Initialization
    protected void initNavigation(int viewPagerId, int tabLayoutId)
    {
        loadViews(viewPagerId, tabLayoutId);
        attachBehaviour();
    }

    private void loadViews(int viewPagerId, int tabLayoutId)
    {
        this.contentPager = findViewById(viewPagerId);
        this.tabLayout = findViewById(tabLayoutId);
    }

    private void attachBehaviour()
    {
        this.contentPager.setAdapter(this.pagerAdapter);
        this.contentPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener()
        {
            @Override
            public void onPageSelected(int position)
            {
                tabLayout.getTabAt(position).select();
            }
        });
        this.tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(this.contentPager));
    }
    // endregion

    public void setPages(Fragment... pages)
    {
        this.pagerAdapter.setPages(pages);
    }
}
