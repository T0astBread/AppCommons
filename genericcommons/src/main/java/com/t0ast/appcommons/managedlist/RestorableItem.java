package com.t0ast.appcommons.managedlist;

public class RestorableItem<T>
{
    final T item;
    final int oldIndex;

    public RestorableItem(int oldIndex, T item)
    {
        this(item, oldIndex);
    }

    public RestorableItem(T item, int oldIndex)
    {
        this.item = item;
        this.oldIndex = oldIndex;
    }

    public T getItem()
    {
        return item;
    }

    public int getOldIndex()
    {
        return oldIndex;
    }
}
