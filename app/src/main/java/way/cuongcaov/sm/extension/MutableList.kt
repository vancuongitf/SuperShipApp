package way.cuongcaov.sm.extension

import way.cuongcaov.sm.data.model.StoreInfoExpress

/**
 *
 * @author at-cuongcao.
 */
internal fun MutableList<StoreInfoExpress>.addAllDistinct(list: List<StoreInfoExpress>) {
    for (store in list) {
        if (this.find { it.storeId == store.storeId } == null) {
            this.add(store)
        }
    }
}
