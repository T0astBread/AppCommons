package cc.t0ast.androidcommons.ui.animations.interpolators;

import android.view.animation.Interpolator;

/**
 * Created by T0astBread on 12.02.2018.
 */

public class ReverseInterpolator implements Interpolator
{
    private Interpolator delegate;

    public ReverseInterpolator(Interpolator delegate)
    {
        this.delegate = delegate;
    }

    @Override
    public float getInterpolation(float input)
    {
        return 1 - this.delegate.getInterpolation(input);
    }

    public Interpolator getDelegate()
    {
        return delegate;
    }
}
