package way.cuongcaov.sm.data.source.remote.util

import retrofit2.Call
import retrofit2.Response
import way.cuongcaov.sm.data.source.remote.network.CustomCallback

/**
 *
 * @author at-hoavo.
 */
class CallBackApi private constructor() {
    companion object {
        internal fun <T> callback(
                onSuccess: (Call<T>, Response<T>) -> Unit = { _, _ -> },
                onError: (Throwable) -> Unit = { }
        ): CustomCallback<T> = object : CustomCallback<T> {
            override fun success(call: Call<T>, response: Response<T>) {
                onSuccess.invoke(call, response)
            }

            override fun onError(t: Throwable) {
                onError.invoke(t)
            }
        }
    }
}
