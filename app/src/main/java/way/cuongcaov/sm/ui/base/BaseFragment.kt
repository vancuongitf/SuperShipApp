package way.cuongcaov.sm.ui.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 *
 *
 */
abstract class BaseFragment : Fragment() {
    private val subscription: CompositeDisposable = CompositeDisposable()

    override fun onPause() {
        super.onPause()
        subscription.clear()
    }

    override fun onResume() {
        super.onResume()
        onBindViewModel()
    }

    protected fun addDisposables(vararg ds: Disposable) {
        ds.forEach { subscription.add(it) }
    }

    /**
     * This function is used to define subscription
     */
    abstract fun onBindViewModel()
}
