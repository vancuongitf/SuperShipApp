package way.cuongcaov.sm.data.source

import way.cuongcaov.sm.data.source.datasource.StoreDataSource
import way.cuongcaov.sm.data.source.remote.StoreRemoteDataSource

/**
 *
 * @author at-cuongcao.
 */
class StoreRepository : StoreDataSource {

    private val storeRemoteDataSource = StoreRemoteDataSource()

    override fun getStoreInfo(storeId: Long) = storeRemoteDataSource.getStoreInfo(storeId)

    override fun getStoreExpressList(advanceParam: Int, page: Int) = storeRemoteDataSource.getStoreExpressList(advanceParam, page)

    override fun searchStore(query: String, page: Int) = storeRemoteDataSource.searchStore(query, page)
}
