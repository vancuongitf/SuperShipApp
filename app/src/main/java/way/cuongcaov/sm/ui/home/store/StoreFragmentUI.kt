package way.cuongcaov.sm.ui.home.store

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.relativeLayout
import way.cuongcaov.sm.R
import way.cuongcaov.sm.data.model.StoreInfoExpress

/**
 *
 * @author at-cuongcao.
 */
class StoreFragmentUI(storeInfoExpresses: MutableList<StoreInfoExpress>) : AnkoComponent<StoreFragment> {
    internal lateinit var recyclerViewStores: RecyclerView
    internal val storeAdapter = StoreAdapter(storeInfoExpresses)

    override fun createView(ui: AnkoContext<StoreFragment>) = with(ui) {
        relativeLayout {
            lparams(matchParent, matchParent)

            recyclerViewStores = recyclerView {
                id = R.id.storeFragmentRecyclerViewStores
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                adapter = storeAdapter
            }.lparams(matchParent, matchParent)
        }
    }
}