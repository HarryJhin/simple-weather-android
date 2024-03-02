package blog.jinhyun.simpleweatherandroid.core.network.client

import androidx.core.os.trace
import blog.jinhyun.simpleweatherandroid.core.network.BuildConfig
import blog.jinhyun.simpleweatherandroid.core.network.api.KoreaMeteorologicalAdministrationApi
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecast
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcast
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcastRequest
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class KoreaMeteorologicalAdministrationApiClient @Inject constructor(
    json: Json,
    okHttpClient: OkHttpClient,
) : ApiClient {

    private val api: KoreaMeteorologicalAdministrationApi = trace("ApiClient") {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .callFactory(okHttpClient::newCall)
            .addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            .build()
            .create(KoreaMeteorologicalAdministrationApi::class.java)
    }

    override suspend fun getUltraShortNowcast(
        request: UltraShortNowcastRequest
    ): List<UltraShortNowcast> {

        val response = api.getUltraShortNowcast(
            serviceKey = BuildConfig.ServiceKey,
            numOfRows = request.numOfRows,
            pageNo = request.pageNo,
            dataType = request.dataType,
            baseDate = request.baseDate,
            baseTime = request.baseTime,
            nx = request.nx,
            ny = request.ny,
        )

        return response.checkIsSuccess().response.body!!.items.item

    }

    override suspend fun getUltraShortForecast(
        request: UltraShortForecastRequest
    ): List<ShortForecast> {

        val response = api.getUltraShortForecast(
            serviceKey = BuildConfig.ServiceKey,
            numOfRows = request.numOfRows,
            pageNo = request.pageNo,
            dataType = request.dataType,
            baseDate = request.baseDate,
            baseTime = request.baseTime,
            nx = request.nx,
            ny = request.ny,
        )

        return response.checkIsSuccess().response.body!!.items.item
    }

    override suspend fun getShortForecast(
        request: ShortForecastRequest
    ): List<ShortForecast> {

        val response = api.getShortForecast(
            serviceKey = BuildConfig.ServiceKey,
            numOfRows = request.numOfRows,
            pageNo = request.pageNo,
            dataType = request.dataType,
            baseDate = request.baseDate,
            baseTime = request.baseTime,
            nx = request.nx,
            ny = request.ny,
        )

        return response.checkIsSuccess().response.body!!.items.item
    }
}