package way.cuongcaov.sm.data.source.remote.network

import io.reactivex.Single
import retrofit2.http.*
import way.cuongcaov.sm.data.model.AccessToken
import way.cuongcaov.sm.data.model.StoreInfoExpress

/**
 *
 * @author at-cuongcao.
 */
interface ApiService {

    @FormUrlEncoded
    @POST("api/v1/user/login.php")
    fun login(@Field("user") user: String, @Field("pass") pass: String): CustomCall<AccessToken>

    @GET("api/v1/store/search.php")
    fun search(@Query("query") query: String, @Query("page") page: Int): Single<List<StoreInfoExpress>>
}
