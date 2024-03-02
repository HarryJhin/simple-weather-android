package blog.jinhyun.simpleweatherandroid.core.network.model

import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkDate
import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkTime
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UltraShortNowcast(
    @SerialName("baseDate")
    val baseDate: NetworkDate,
    @SerialName("baseTime")
    val baseTime: NetworkTime,
    @SerialName("nx")
    val nx: Int,
    @SerialName("ny")
    val ny: Int,
    @SerialName("category")
    val categoryCode: CategoryCode,
    @SerialName("obsrValue")
    val value: Double,
)