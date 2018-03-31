package way.cuongcaov.sm.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import way.cuongcaov.sm.R
import way.cuongcaov.sm.extension.addChildFragment
import way.cuongcaov.sm.extension.animBotToTop
import way.cuongcaov.sm.ui.base.BaseFragment
import way.cuongcaov.sm.ui.home.main.HomeFragment
import way.cuongcaov.sm.ui.home.search.SearchDialogFragment

/**
 *
 * @author at-cuongcao.
 */
class HomeContainer : BaseFragment() {

    private lateinit var ui: HomeContainerUI

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        ui = HomeContainerUI()
        return ui.createView(AnkoContext.Companion.create(context, this))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        addChildFragment(R.id.homeContainer, HomeFragment(), null)
    }

    override fun onBindViewModel() = Unit

    internal fun openSearchDialog() {
        addChildFragment(R.id.homeContainer, SearchDialogFragment(), SearchDialogFragment::class.java.simpleName, {
            it.animBotToTop()
        })
    }
}
