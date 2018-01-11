package com.t0ast.androidcommons.ui.listeners;

import android.widget.AbsListView;

/**
 * Created by T0astBread on 03.12.2017.
 */

public abstract class ScrollDirectionListener implements AbsListView.OnScrollListener
{
    private int lastItem;

    @Override
    public void onScroll(AbsListView view, int currentItem, int visibleItemCount, int totalItemCount)
    {
        if(currentItem < lastItem) onScrollDown(currentItem, this.lastItem);
        else if(currentItem > lastItem) onScrollUp(currentItem, this.lastItem);
        this.lastItem = currentItem;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState)
    {
    }

    //    @Override
//    public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY)
//    {
//        if(oldScrollY > scrollY) onScrollDown(oldScrollY - scrollY);
//        else onScrollUp(scrollY - oldScrollY);
//    }

    public abstract void onScrollUp(int currentItemPos, int lastItemPos);
    public abstract void onScrollDown(int currentItemPos, int lastItemPos);
}
