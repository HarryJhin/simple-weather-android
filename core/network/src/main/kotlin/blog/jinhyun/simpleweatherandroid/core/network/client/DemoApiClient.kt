package blog.jinhyun.simpleweatherandroid.core.network.client

import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.Dispatcher
import blog.jinhyun.simpleweatherandroid.core.common.dispatcher.DispatcherType.IO
import AssetManager
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecast
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcast
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcastRequest
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
internal class DemoApiClient @Inject constructor(
    private val json: Json,
    @Dispatcher(IO) private val dispatcher: CoroutineDispatcher,
) : ApiClient {

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getUltraShortNowcast(
        request: UltraShortNowcastRequest
    ): List<UltraShortNowcast> = withContext(dispatcher) {
        AssetManager.open(ULTRA_SHORT_NOWCAST_ASSET).use(json::decodeFromStream)
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getUltraShortForecast(
        request: UltraShortForecastRequest
    ): List<ShortForecast> = withContext(dispatcher) {
        AssetManager.open(ULTRA_SHORT_FORECAST_ASSET).use(json::decodeFromStream)
    }

    @OptIn(ExperimentalSerializationApi::class)
    override suspend fun getShortForecast(
        request: ShortForecastRequest
    ): List<ShortForecast> = withContext(dispatcher) {
        AssetManager.open(SHORT_FORECAST_ASSET).use(json::decodeFromStream)
    }

    private companion object {
        const val ULTRA_SHORT_NOWCAST_ASSET = "ultra_short_nowcast.json"
        const val ULTRA_SHORT_FORECAST_ASSET = "ultra_short_forecast.json"
        const val SHORT_FORECAST_ASSET = "short_forecast.json"
    }
}