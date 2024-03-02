package blog.jinhyun.simpleweatherandroid.core.common.kotlin.datetime

import java.time.format.DateTimeFormatter

@Suppress("EnumEntryName")
enum class DateTimeFormat(
    val formatter: DateTimeFormatter,
) {
    DATE_TIME(DateTimeFormatter.ISO_LOCAL_DATE_TIME),
    DATE(DateTimeFormatter.ISO_LOCAL_DATE),
    TIME(DateTimeFormatter.ISO_LOCAL_TIME),
    yyyyMMdd(DateTimeFormatter.ofPattern("yyyyMMdd")),
    HHmmss(DateTimeFormatter.ofPattern("HHmmss")),
    HHmm(DateTimeFormatter.ofPattern("HHmm")),
    yyyyMMddHHmmss(DateTimeFormatter.ofPattern("yyyyMMddHHmmss")),
}