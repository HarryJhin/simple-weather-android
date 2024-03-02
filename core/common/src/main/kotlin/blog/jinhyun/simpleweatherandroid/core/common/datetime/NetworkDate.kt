package blog.jinhyun.simpleweatherandroid.core.common.datetime

import blog.jinhyun.simpleweatherandroid.core.common.datetime.serializer.NetworkDateSerializer
import blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime.DateTimeFormat
import kotlinx.serialization.Serializable
import java.time.DayOfWeek
import java.time.Month
import java.time.LocalDate as JtLocalDate

@Suppress("Unused")
@Serializable(with = NetworkDateSerializer::class)
class NetworkDate internal constructor(
    internal val value: JtLocalDate,
) : Comparable<NetworkDate> {

    constructor(
        year: Int,
        monthValue: Int,
        dayOfMonth: Int,
    ) : this(JtLocalDate.of(year, monthValue, dayOfMonth))

    val year: Int get() = value.year
    val monthNumber: Int get() = value.monthValue
    val month: Month get() = value.month
    val dayOfMonth: Int get() = value.dayOfMonth
    val dayOfWeek: DayOfWeek get() = value.dayOfWeek
    val dayOfYear: Int get() = value.dayOfYear

    override fun compareTo(other: NetworkDate): Int = this.value.compareTo(other.value)

    override fun toString(): String = value.format(DateTimeFormat.yyyyMMdd.formatter)

    companion object {
        val MIN: NetworkDate = NetworkDate(JtLocalDate.MIN)
        val MAX: NetworkDate = NetworkDate(JtLocalDate.MAX)

        fun parse(string: String): NetworkDate =
            JtLocalDate.parse(string, DateTimeFormat.yyyyMMdd.formatter)
                .let(::NetworkDate)

        fun now(): NetworkDate = NetworkDate(JtLocalDate.now())
    }
}