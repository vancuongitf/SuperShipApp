package way.cuongcaov.sm.ui.home.store

import com.google.android.gms.maps.model.LatLng
import io.reactivex.Notification
import io.reactivex.subjects.PublishSubject
import way.cuongcaov.sm.data.model.StoreInfoExpress
import way.cuongcaov.sm.data.model.StoreRate
import way.cuongcaov.sm.data.source.remote.response.StoreExpressResponse

/**
 *
 * @author at-cuongcao.
 */
class StoreFragmentViewModel(private val advanceParam: Int) {

    internal val getExpressesStoreObservable = PublishSubject.create<Notification<StoreExpressResponse>>()
    internal val stores = mutableListOf<StoreInfoExpress>()

    internal fun getExpressesStore(page: Int) {
        val storeList = mutableListOf<StoreInfoExpress>()
        for (i in 0..20) {
            storeList.add(StoreInfoExpress(1L, "Milk Tea", "Binh Dao - Thang Binh - Quang Nam", LatLng(100.0, 100.0), 1213123L, StoreRate(4.1, 55), "http://www.sakura668.com/wp-content/uploads/2016/05/Milk-Tea.jpg"))
        }
        getExpressesStoreObservable.onNext(Notification.createOnNext(StoreExpressResponse(false, storeList)))
    }
}
