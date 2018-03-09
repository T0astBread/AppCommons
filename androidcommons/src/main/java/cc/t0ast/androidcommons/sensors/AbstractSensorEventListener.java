package cc.t0ast.androidcommons.sensors;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

/**
 * Created by T0astBread on 12.02.2018.
 */
public abstract class AbstractSensorEventListener implements SensorEventListener
{
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy)
    {
    }
}
