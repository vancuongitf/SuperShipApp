package way.cuongcaov.sm.ui.home.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import way.cuongcaov.sm.ui.base.BaseFragment
import way.cuongcaov.sm.ui.home.HomeContainer

/**
 *
 * @author at-cuongcao.
 */
class HomeFragment : BaseFragment() {

    private lateinit var ui: HomeFragmentUI
    private lateinit var viewModel: HomeFragmentViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = HomeFragmentViewModel()
        ui = HomeFragmentUI(HomeFragmentAdapter(childFragmentManager))
        return ui.createView(AnkoContext.Companion.create(context, this))
    }

    override fun onBindViewModel() = Unit

    internal fun handleSearchViewClicked() {
        Log.i("tag11","xxxxx")
        (parentFragment as? HomeContainer)?.openSearchDialog()
    }
}
