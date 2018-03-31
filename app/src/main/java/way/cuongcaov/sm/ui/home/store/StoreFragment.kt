package way.cuongcaov.sm.ui.home.store

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Notification
import org.jetbrains.anko.AnkoContext
import way.cuongcaov.sm.data.source.remote.response.StoreExpressResponse
import way.cuongcaov.sm.ui.base.BaseFragment

/**
 *
 * @author at-cuongcao.
 */
class StoreFragment : BaseFragment() {

    companion object {

        internal const val KEY_ADVANCE = "KEY_ADVANCE"

        internal fun getNewInstance(advanceParam: StoreFragmentAdvanceParam) = StoreFragment().apply {
            arguments = Bundle().apply {
                this.putInt(KEY_ADVANCE, advanceParam.advanceParam)
            }
        }
    }

    private lateinit var viewModel: StoreFragmentViewModel
    private lateinit var ui: StoreFragmentUI

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = StoreFragmentViewModel(arguments.getInt(KEY_ADVANCE))
        ui = StoreFragmentUI(viewModel.stores)
        return ui.createView(AnkoContext.create(context, this))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getExpressesStoreObservable.subscribe(this::handleGetStoreListCompleted, {})
        viewModel.getExpressesStore(0)
    }

    override fun onBindViewModel() = Unit

    private fun handleGetStoreListCompleted(notification: Notification<StoreExpressResponse>) {
        if (notification.isOnNext) {
            notification.value?.let {
                viewModel.stores.addAll(it.storeList)
                ui.storeAdapter.notifyDataSetChanged()
            }
        }
    }
}
