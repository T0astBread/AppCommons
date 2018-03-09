package cc.t0ast.androidcommons.ui;

import java.lang.reflect.Field;

/**
 * Created by T0astBread on 08.01.2018.
 */

public class UiUtils
{
    public static int getIdFromString(Class r, String idName)
    {
        try
        {
            Field idField = r.getDeclaredField(idName);
            return (int) idField.get(null);
        }
        catch(ReflectiveOperationException e)
        {
            return -1;
        }
    }
}
