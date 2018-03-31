package way.cuongcaov.sm.ui.home.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.jetbrains.anko.AnkoContext
import way.cuongcaov.sm.ui.base.BaseFragment

/**
 *
 * @author at-cuongcao.
 */
class SearchDialogFragment : BaseFragment() {

    private lateinit var ui: SearchDialogFragmentUI
    private lateinit var viewModel: SearchDialogViewModel

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = SearchDialogViewModel()
        ui = SearchDialogFragmentUI(viewModel.stores)
        return ui.createView(AnkoContext.Companion.create(context, this))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.search("")
    }

    internal fun handleSearchViewTextChange(query: String) {
        viewModel.search(query)
    }

    override fun onBindViewModel() {

    }
}