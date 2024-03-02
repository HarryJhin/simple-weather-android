package blog.jinhyun.simpleweatherandroid.core.network.model

import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkDate
import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkTime
import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalTime
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ShortForecast(
    @SerialName("baseDate")
    private val baseDate: NetworkDate,
    @SerialName("baseTime")
    private val baseTime: NetworkTime,
    @SerialName("category")
    val categoryCode: CategoryCode,
    @SerialName("fcstDate")
    private val forecastDate: NetworkDate,
    @SerialName("fcstTime")
    private val forecastTime: NetworkTime,
    @SerialName("fcstValue")
    val value: String,
    @SerialName("nx")
    val nx: Int,
    @SerialName("ny")
    val ny: Int,
)