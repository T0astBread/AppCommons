package com.t0ast.appcommons.managedlist;

import com.annimon.stream.Stream;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Michael on 27.11.2017.
 */

public class ManagedList<T> extends ArrayList<T>
{
    private RestorationList<T> restorationList;
    private List<Listener> listeners;
    private boolean autoNotify;

    public ManagedList()
    {
        this.restorationList = new RestorationList<>();
        this.listeners = new ArrayList<>();
    }

    public void setAutoNotify(boolean autoNotify)
    {
        this.autoNotify = autoNotify;
    }

    @Override
    public boolean add(T t)
    {
        boolean result = super.add(t);
        if(this.autoNotify) notifyListeners();
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends T> c)
    {
        boolean result = super.addAll(c);
        if(this.autoNotify) notifyListeners();
        return result;
    }

    @Override
    public T set(int index, T newT)
    {
        T result = super.set(index, newT);
        if(this.autoNotify) notifyListeners();
        return result;
    }

    public T remove(int index)
    {
        this.restorationList.makeRestorable(index, get(index));
        T result = super.remove(index);
        if(this.autoNotify) notifyListeners();
        return result;
    }

    public void storeAndClear()
    {
        this.restorationList.makeSequenceRestorable(this);
        clear();
    }

    @Override
    public void clear()
    {
        super.clear();
        if(this.autoNotify) notifyListeners();
    }

    public void restore()
    {
        this.restorationList.restore(this);
        if(this.autoNotify) notifyListeners();
    }

    public void registerListener(Listener listener)
    {
        this.listeners.add(listener);
    }

    public void unregisterListener(Listener listener)
    {
        this.listeners.remove(listener);
    }

    public void notifyListeners()
    {
        Stream.of(this.listeners).forEach(Listener::notifyDataChanged);
    }

    public interface Listener
    {
        void notifyDataChanged();
    }
}
