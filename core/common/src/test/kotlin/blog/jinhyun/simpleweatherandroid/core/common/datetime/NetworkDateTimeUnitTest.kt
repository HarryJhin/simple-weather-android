package blog.jinhyun.simpleweatherandroid.core.common.datetime

import org.junit.Test
import kotlin.test.assertEquals
import kotlin.time.Duration.Companion.hours

class NetworkDateTimeUnitTest {

    @Test
    fun `2024년 3월 3일 정각 1시간 전`() {
        val dateTime = NetworkDateTime(
            year = 2024,
            monthNumber = 3,
            dayOfMonth = 3,
            hour = 0,
            minute = 0,
            second = 0,
            nanosecond = 0,
        )

        assertEquals(
            2,
            (dateTime - 1.hours).dayOfMonth
        )
    }
}