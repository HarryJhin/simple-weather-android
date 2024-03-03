package blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDateTime
import kotlinx.datetime.toLocalDateTime

fun LocalDateTime.Companion.now(
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDateTime = Clock.System.now().toLocalDateTime(timeZone)

fun LocalDateTime.format(
    format: DateTimeFormat = DateTimeFormat.DATE_TIME
): String = format.formatter.format(toJavaLocalDateTime())