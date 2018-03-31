package way.cuongcaov.sm.data.source.remote

import io.reactivex.Single
import way.cuongcaov.sm.data.model.Store
import way.cuongcaov.sm.data.source.datasource.StoreDataSource
import way.cuongcaov.sm.data.source.remote.network.ApiClient
import way.cuongcaov.sm.data.source.remote.response.StoreExpressResponse

/**
 *
 * @author at-cuongcao.
 */
class StoreRemoteDataSource : StoreDataSource {

    private val apiService = ApiClient.getInstance(null).service

    override fun searchStore(query: String, page: Int) = apiService.search(query, page)

    override fun getStoreInfo(storeId: Long): Single<Store> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getStoreExpressList(advanceParam: Int, page: Int): Single<StoreExpressResponse> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


//    override fun getStoreInfo(storeId: Long) = apiService.getStoreInfo(storeId).subscribeOn(Schedulers.io())!!
//
//    override fun getStoreExpressList(advanceParam: Int, page: Int) = apiService.getExpressStore(advanceParam, page).subscribeOn(Schedulers.io())!!
}
