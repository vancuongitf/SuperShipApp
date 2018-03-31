package way.cuongcaov.sm.extension

import android.content.Context
import android.location.LocationManager
import android.net.ConnectivityManager
import android.util.DisplayMetrics
import android.view.WindowManager


/**
 *
 * @author at-cuongcao.
 */
internal fun Context.isNetworkConnection(): Boolean {
    val cm = getSystemService(Context.CONNECTIVITY_SERVICE) as? ConnectivityManager
    return cm?.activeNetworkInfo != null
}

internal fun Context.isGPSEnable(): Boolean {
    val manager = getSystemService(Context.LOCATION_SERVICE) as? LocationManager
    return manager != null && manager.isProviderEnabled(LocationManager.GPS_PROVIDER)
}

internal fun Context.getWidthScreen(): Int {
    val wm = getSystemService(Context.WINDOW_SERVICE) as? WindowManager
    val dimension = DisplayMetrics()
    wm?.defaultDisplay?.getMetrics(dimension)
    return dimension.widthPixels
}

internal fun Context.getHeightScreen(): Int {
    val wm = getSystemService(Context.WINDOW_SERVICE) as? WindowManager
    val dimension = DisplayMetrics()
    wm?.defaultDisplay?.getMetrics(dimension)
    return dimension.heightPixels
}
