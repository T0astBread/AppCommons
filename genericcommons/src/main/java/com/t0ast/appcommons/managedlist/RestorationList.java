package com.t0ast.appcommons.managedlist;

import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael on 06.11.2017.
 */

public class RestorationList<T>
{
    private List<RestorableItem<T>> items;

    public RestorationList()
    {
        this.items = new ArrayList<>();
    }

    public void makeRestorable(int oldIndex, T item)
    {
        this.items.clear();
        this.items.add(new RestorableItem<T>(item, oldIndex));
    }

    public void makeRestorable(Iterable<RestorableItem<T>> items)
    {
        this.items.clear();
        Stream.of(items).forEach(this.items::add);
    }

    public void makeSequenceRestorable(Iterable<T> items)
    {
        makeRestorable(Stream.of(items).mapIndexed(RestorableItem::new).toList());
    }

    public void restore(List<T> destination)
    {
        Stream.of(this.items).forEach(i -> destination.add(i.getOldIndex(), i.getItem()));
    }
}
