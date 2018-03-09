package cc.t0ast.androidcommons.permissions;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/**
 * Created by T0astBread on 04.12.2017.
 */

public class PermissionUtils
{
    public static boolean ensurePermissionIsGranted(Context context, String permission)
    {
        if(Build.VERSION.SDK_INT <= Build.VERSION_CODES.M) return true;
        return context.checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED;
    }
}
