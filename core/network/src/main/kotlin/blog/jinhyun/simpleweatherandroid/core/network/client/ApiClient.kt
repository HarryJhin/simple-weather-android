package blog.jinhyun.simpleweatherandroid.core.network.client

import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecast
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcast
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcastRequest

sealed interface ApiClient {

    suspend fun getUltraShortNowcast(request: UltraShortNowcastRequest): List<UltraShortNowcast>

    suspend fun getUltraShortForecast(request: UltraShortForecastRequest): List<ShortForecast>

    suspend fun getShortForecast(request: ShortForecastRequest): List<ShortForecast>
}