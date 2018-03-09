package cc.t0ast.androidcommons.location;

import android.content.Context;
import android.location.Location;

import com.annimon.stream.function.Supplier;

/**
 * Created by T0astBread on 06.12.2017.
 */

public class LocationProvider implements Supplier<Location>
{
    private Context context;

    public LocationProvider(Context context)
    {
        this.context = context;
    }

    @Override
    public Location get()
    {
        return LocationUtils.getBestLastLocation(this.context);
    }
}
