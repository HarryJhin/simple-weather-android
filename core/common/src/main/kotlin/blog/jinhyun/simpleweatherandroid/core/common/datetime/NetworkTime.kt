package blog.jinhyun.simpleweatherandroid.core.common.datetime

import blog.jinhyun.simpleweatherandroid.core.common.datetime.serializer.NetworkTimeSerializer
import blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime.DateTimeFormat
import kotlinx.serialization.Serializable
import java.time.LocalTime as JtLocalTime

@Suppress("Unused")
@Serializable(with = NetworkTimeSerializer::class)
class NetworkTime internal constructor(
    internal val value: JtLocalTime,
) : Comparable<NetworkTime> {

    constructor(
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int,
    ) : this(JtLocalTime.of(hour, minute, second, nanosecond))

    val hour: Int get() = value.hour
    val minute: Int get() = value.minute
    val second: Int get() = value.second
    val nanosecond: Int get() = value.nano

    override fun equals(other: Any?): Boolean =
        (this === other) || (other is NetworkTime && this.value == other.value)

    override fun hashCode(): Int = value.hashCode()

    override fun toString(): String = value.format(DateTimeFormat.HHmm.formatter)

    override fun compareTo(other: NetworkTime): Int = this.value.compareTo(other.value)

    companion object {
        val MIN: NetworkTime = NetworkTime(JtLocalTime.MIN)
        val MAX: NetworkTime = NetworkTime(JtLocalTime.MAX)

        fun parse(string: String): NetworkTime =
            JtLocalTime.parse(string, DateTimeFormat.HHmm.formatter)
                .let(::NetworkTime)

        fun now(): NetworkTime {
            val now = JtLocalTime.now()

            return NetworkTime(JtLocalTime.of(now.hour, now.minute, 0, 0))
        }
    }
}