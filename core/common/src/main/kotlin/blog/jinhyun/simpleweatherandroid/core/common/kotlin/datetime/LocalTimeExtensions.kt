package blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime

import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalTime
import kotlinx.datetime.toKotlinLocalTime
import java.time.LocalTime as JtLocalTime

fun LocalTime.Companion.now(
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalTime = LocalDateTime.now(timeZone).time

fun LocalTime.format(
    format: DateTimeFormat = DateTimeFormat.TIME
): String = format.formatter.format(toJavaLocalTime())

fun LocalTime.Companion.parse(
    text: String,
    format: DateTimeFormat = DateTimeFormat.TIME
): LocalTime = JtLocalTime.parse(text, format.formatter).toKotlinLocalTime()