package cc.t0ast.androidcommons.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/**
 * Created by T0astBread on 06.12.2017.
 */

public class LocationUtils
{
    public static Location getBestLastLocation(Context context)
    {
        LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        Location networkLoc = manager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        Location gpsLoc = manager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        if(networkLoc == null) return gpsLoc;
        if(gpsLoc == null) return networkLoc;
        return networkLoc.getTime() < gpsLoc.getTime() ? networkLoc : gpsLoc;
    }
}
