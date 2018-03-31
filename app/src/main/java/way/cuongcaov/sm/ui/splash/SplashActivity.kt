package way.cuongcaov.sm.ui.splash

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.animation.AccelerateInterpolator
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.jetbrains.anko.alert
import org.jetbrains.anko.noButton
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.yesButton
import way.cuongcaov.sm.R
import way.cuongcaov.sm.extension.isGPSEnable
import way.cuongcaov.sm.extension.isNetworkConnection
import way.cuongcaov.sm.ui.base.BaseActivity
import way.cuongcaov.sm.ui.main.MainActivity
import java.util.concurrent.TimeUnit


/**
 *
 * @author at-cuongcao.
 */
class SplashActivity : BaseActivity() {

    companion object {
        const val REQUEST_CODE_TURN_ON_GSP = 22
        const val REQUEST_CODE_TURN_ON_NETWORK = 2
    }

    private lateinit var ui: SplashActivityUI
    private var discardNetwork = false
    private var discardGps = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = SplashActivityUI()
        ui.setContentView(this)
        Observable.interval(0, 5000, TimeUnit.MILLISECONDS)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    ui.imgShipper.startAnimation(inFromLeftAnimation())
                })
    }

    override fun onBindViewModel() {
        if (!discardGps) {
            checkGpsStatus()
            return
        }
        if (!discardNetwork) {
            checkNetworkStatus()
            return
        }
        startActivity(Intent(this, MainActivity::class.java))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        when (requestCode) {
            REQUEST_CODE_TURN_ON_GSP -> {

            }

            REQUEST_CODE_TURN_ON_NETWORK -> {

            }
        }
    }

    private fun inFromLeftAnimation(): Animation {
        val inFromLeft = TranslateAnimation(
                Animation.RELATIVE_TO_PARENT, -0.5f,
                Animation.RELATIVE_TO_PARENT, 1.5f,
                Animation.RELATIVE_TO_PARENT, 0.0f,
                Animation.RELATIVE_TO_PARENT, 0.0f)
        inFromLeft.duration = 5000
        inFromLeft.interpolator = AccelerateInterpolator()
        return inFromLeft
    }

    private fun checkGpsStatus() {
        if (!isGPSEnable()) {
            alert {
                title = getString(R.string.notification_string)
                messageResource = R.string.turn_on_gps_message
                isCancelable = false
                discardGps = true
                yesButton {
                    val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                    startActivityForResult(intent, REQUEST_CODE_TURN_ON_GSP)
                }

                noButton {
                    onBindViewModel()
                }
            }.show()
        } else {
            discardGps = true
            onBindViewModel()
        }
    }

    private fun checkNetworkStatus() {
        if (!isNetworkConnection()) {
            alert {
                title = getString(R.string.notification_string)
                messageResource = R.string.turn_on_network_message
                isCancelable = false
                discardNetwork = true
                yesButton {
                    val intent = Intent(Settings.ACTION_WIRELESS_SETTINGS)
                    startActivityForResult(intent, REQUEST_CODE_TURN_ON_NETWORK)
                }

                noButton {
                    onBindViewModel()
                }
            }.show()
        } else {
            discardNetwork = true
            onBindViewModel()
        }
    }
}
