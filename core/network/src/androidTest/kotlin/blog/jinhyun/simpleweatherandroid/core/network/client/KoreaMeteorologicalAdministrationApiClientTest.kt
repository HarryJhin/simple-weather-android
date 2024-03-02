package blog.jinhyun.simpleweatherandroid.core.network.client

import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortForecastRequest
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcastRequest
import blog.jinhyun.simpleweatherandroid.core.testing.rule.DispatcherRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.test.assertNotEquals

@HiltAndroidTest
class KoreaMeteorologicalAdministrationApiClientTest {

    @get:Rule
    val hiltAndroidRule = HiltAndroidRule(this)

    @get:Rule
    val dispatcherRule = DispatcherRule()

    @Inject
    internal lateinit var apiClient: KoreaMeteorologicalAdministrationApiClient

    @Before
    fun setUp() {
        hiltAndroidRule.inject()
    }

    @Test
    fun getUltraShortNowcast() = runTest {
        val nowcastList = apiClient.getUltraShortNowcast(UltraShortNowcastRequest())

        assertNotEquals(0, nowcastList.size)
    }

    @Test
    fun getUltraShortForecast() = runTest {
        val forecastList = apiClient.getUltraShortForecast(UltraShortForecastRequest())

        assertNotEquals(0, forecastList.size)
    }

    @Test
    fun getShortForecast() = runTest {
        val forecastList = apiClient.getShortForecast(ShortForecastRequest())

        assertNotEquals(0, forecastList.size)
    }
}