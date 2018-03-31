package way.cuongcaov.sm.data.source.remote.response

import com.google.gson.annotations.SerializedName
import way.cuongcaov.sm.data.model.StoreInfoExpress

/**
 *
 * @author at-cuongcao.
 */
data class StoreExpressResponse(@SerializedName("next_page_flag") var nextPageFlag: Boolean,
                                @SerializedName("store_list") var storeList: MutableList<StoreInfoExpress>)
