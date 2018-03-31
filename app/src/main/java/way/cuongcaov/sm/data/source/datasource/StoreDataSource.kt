package way.cuongcaov.sm.data.source.datasource

import io.reactivex.Single
import way.cuongcaov.sm.data.model.Store
import way.cuongcaov.sm.data.model.StoreInfoExpress
import way.cuongcaov.sm.data.source.remote.response.StoreExpressResponse

/**
 *
 * @author at-cuongcao.
 */
interface StoreDataSource {

    fun getStoreInfo(storeId: Long): Single<Store>

    fun getStoreExpressList(advanceParam: Int, page: Int): Single<StoreExpressResponse>

    fun searchStore(query: String, page: Int): Single<List<StoreInfoExpress>>
}
