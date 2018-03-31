package way.cuongcaov.sm.ui.store

import org.jetbrains.anko.*
import org.jetbrains.anko.appcompat.v7.toolbar
import way.cuongcaov.sm.R

/**
 *
 * @author at-cuongcao.
 */
class StoreFragmentUI : AnkoComponent<StoreFragment> {
    override fun createView(ui: AnkoContext<StoreFragment>) = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)

            toolbar {

            }.lparams(matchParent, dimen(R.dimen.toolBarHeight))
        }
    }
}
