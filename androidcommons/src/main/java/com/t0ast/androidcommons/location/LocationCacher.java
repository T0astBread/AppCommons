package com.t0ast.androidcommons.location;

import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;

import com.annimon.stream.function.Supplier;

/**
 * Created by T0astBread on 04.12.2017.
 */

public class LocationCacher implements LocationListener, Supplier<Location>
{
    private Location location;

    @Override
    public void onLocationChanged(Location location)
    {
        this.location = location;
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras)
    {
    }

    @Override
    public void onProviderEnabled(String provider)
    {
    }

    @Override
    public void onProviderDisabled(String provider)
    {
    }

    @Override
    public Location get()
    {
        return this.location;
    }
}
