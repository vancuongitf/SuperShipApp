package way.cuongcaov.sm.ui.home.store

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import org.jetbrains.anko.AnkoContext
import way.cuongcaov.sm.R
import way.cuongcaov.sm.data.model.StoreInfoExpress
import way.cuongcaov.sm.extension.getDistanceString

/**
 *
 * @author at-cuongcao.
 */
class StoreAdapter(private val storeInfoExpresses: MutableList<StoreInfoExpress>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_ITEM = 1
        private const val TYPE_LOAD_MORE = 2
    }

    internal var nextPageFlag = false
    internal var onItemClicked: (item: StoreInfoExpress) -> Unit = {}

    override fun getItemCount() = if (nextPageFlag) {
        storeInfoExpresses.size + 1
    } else {
        storeInfoExpresses.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoreHolder {
        val ui = StoreItemUI()
        return StoreHolder(ui, ui.createView(AnkoContext.Companion.create(parent.context, parent)))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (position < itemCount - 1) {
            (holder as? StoreHolder)?.onBind()
        }
    }

    override fun getItemViewType(position: Int) = when (position) {
        storeInfoExpresses.size -> TYPE_LOAD_MORE

        else -> TYPE_ITEM
    }


    inner class StoreHolder(val ui: StoreItemUI, itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val option = RequestOptions()
                .placeholder(R.drawable.ic_picture)

        init {
            itemView.setOnClickListener {
                onItemClicked(storeInfoExpresses[adapterPosition])
            }
        }

        internal fun onBind() {
            with(storeInfoExpresses[adapterPosition]) {
                Glide.with(itemView.context)
                        .applyDefaultRequestOptions(option)
                        .asBitmap()
                        .load(storeImage)
                        .into(ui.imgStoreIcon)
                ui.tvStoreName.text = storeName
                ui.tvStoreAddress.text = storeAddress
                ui.tvStoreDistance.text = (135L).getDistanceString()
            }
        }
    }
}