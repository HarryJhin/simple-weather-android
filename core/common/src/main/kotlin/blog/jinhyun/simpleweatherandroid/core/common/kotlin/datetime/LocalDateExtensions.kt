package blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime

import kotlinx.datetime.Clock
import kotlinx.datetime.LocalDate
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toJavaLocalDate
import kotlinx.datetime.toKotlinLocalDate
import kotlinx.datetime.toLocalDateTime
import java.time.LocalDate as JtLocalDate

fun LocalDate.Companion.now(
    timeZone: TimeZone = TimeZone.currentSystemDefault()
): LocalDate = Clock.System.now().toLocalDateTime(timeZone).date

fun LocalDate.format(
    dateTimeFormat: DateTimeFormat = DateTimeFormat.DATE
): String = dateTimeFormat.formatter.format(toJavaLocalDate())

fun LocalDate.Companion.parse(
    text: String,
    dateTimeFormat: DateTimeFormat = DateTimeFormat.DATE
): LocalDate = JtLocalDate.parse(text, dateTimeFormat.formatter).toKotlinLocalDate()