package blog.jinhyun.simpleweatherandroid.core.common.datetime

import java.time.DayOfWeek
import java.time.Month
import kotlin.time.Duration
import java.time.LocalDateTime as JtLocalDateTime

@Suppress("Unused")
class NetworkDateTime internal constructor(
    internal val value: JtLocalDateTime,
) : Comparable<NetworkDateTime> {

    constructor(
        year: Int,
        monthNumber: Int,
        dayOfMonth: Int,
        hour: Int,
        minute: Int,
        second: Int,
        nanosecond: Int,
    ) : this(JtLocalDateTime.of(year, monthNumber, dayOfMonth, hour, minute, second, nanosecond))

    constructor(
        date: NetworkDate,
        time: NetworkTime,
    ) : this(JtLocalDateTime.of(date.value, time.value))

    val year: Int get() = value.year
    val monthNumber: Int get() = value.monthValue
    val month: Month get() = value.month
    val dayOfMonth: Int get() = value.dayOfMonth
    val dayOfWeek: DayOfWeek get() = value.dayOfWeek
    val dayOfYear: Int get() = value.dayOfYear
    val hour: Int get() = value.hour
    val minute: Int get() = value.minute
    val second: Int get() = value.second
    val nanosecond: Int get() = value.nano

    val date: NetworkDate get() = NetworkDate(value.toLocalDate())
    val time: NetworkTime get() = NetworkTime(value.toLocalTime())

    operator fun plus(duration: Duration): NetworkDateTime =
        duration.toComponents { seconds, nanoseconds ->
            NetworkDateTime(value.plusSeconds(seconds).plusNanos(nanoseconds.toLong()))
        }

    operator fun minus(duration: Duration): NetworkDateTime = plus(-duration)

    override fun compareTo(other: NetworkDateTime): Int = this.value.compareTo(other.value)

    companion object {
        val MIN: NetworkDateTime = NetworkDateTime(JtLocalDateTime.MIN)
        val MAX: NetworkDateTime = NetworkDateTime(JtLocalDateTime.MAX)

        fun now(): NetworkDateTime = NetworkDateTime(NetworkDate.now(), NetworkTime.now())
    }
}