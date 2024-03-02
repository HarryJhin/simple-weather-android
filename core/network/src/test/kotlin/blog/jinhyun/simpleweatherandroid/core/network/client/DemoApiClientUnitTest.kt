package blog.jinhyun.simpleweatherandroid.core.network.client

import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcastRequest
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Before
import org.junit.Test
import kotlin.test.assertNotEquals

class DemoApiClientUnitTest {

    private lateinit var apiClient: DemoApiClient

    private val testDispatcher = StandardTestDispatcher()

    @Before
    fun setUp() {
        apiClient = DemoApiClient(
            json = Json {
                ignoreUnknownKeys = true
            },
            dispatcher = testDispatcher
        )
    }

    @Test
    fun getUltraShortNowcast() = runTest(testDispatcher) {
        val result = apiClient.getUltraShortNowcast(UltraShortNowcastRequest())

        assertNotEquals(
            0,
            result.size
        )
    }

    @Test
    fun getUltraShortForecast() = runTest(testDispatcher) {
        val result = apiClient.getUltraShortForecast(UltraShortForecastRequest())

        assertNotEquals(
            0,
            result.size
        )
    }

    @Test
    fun getShortForecast() = runTest(testDispatcher) {
        val result = apiClient.getShortForecast(ShortForecastRequest())

        assertNotEquals(
            0,
            result.size
        )
    }
}