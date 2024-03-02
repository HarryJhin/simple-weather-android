package blog.jinhyun.simpleweatherandroid.core.network.model

import blog.jinhyun.simpleweatherandroid.core.common.datetime.NetworkDateTime
import blog.jinhyun.simpleweatherandroid.core.network.ShortForecastMap
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

sealed interface Request {
    val numOfRows: Int
    val pageNo: Int
    val dataType: DataType
    val latitude: Double
    val longitude: Double
    val nx: Int
    val ny: Int
    val baseDate: String
    val baseTime: String
}

/**
 * ### 초단기 실황 요청
 *
 * 매시간 30분에 생성되고 10분마다 최신 정보로 갱신된다.
 *
 * |기준시간|생성시간|base_time|api 제공 시간(~이후)|
 * |:---:|:---:|:---:|:---:|
 * |00시|00:30|0000|00:40|
 * |01시|01:30|0100|01:40|
 * |02시|02:30|0200|02:40|
 * |03시|03:30|0300|03:40|
 * |04시|04:30|0400|04:40|
 * |05시|05:30|0500|05:40|
 * |06시|06:30|0600|06:40|
 * |07시|07:30|0700|07:40|
 * |08시|08:30|0800|08:40|
 * |09시|09:30|0900|09:40|
 * |10시|10:30|1000|10:40|
 * |11시|11:30|1100|11:40|
 * |12시|12:30|1200|12:40|
 * |13시|13:30|1300|13:40|
 * |14시|14:30|1400|14:40|
 * |15시|15:30|1500|15:40|
 * |16시|16:30|1600|16:40|
 * |17시|17:30|1700|17:40|
 * |18시|18:30|1800|18:40|
 * |19시|19:30|1900|19:40|
 * |20시|20:30|2000|20:40|
 * |21시|21:30|2100|21:40|
 * |22시|22:30|2200|22:40|
 * |23시|23:30|2300|23:40|
 */
data class UltraShortNowcastRequest(
    override val numOfRows: Int = 100,
    override val pageNo: Int = 1,
    override val dataType: DataType = DataType.JSON,
    override val latitude: Double = 37.506406,
    override val longitude: Double = 127.05943,
) : Request {

    private val baseDateTime: NetworkDateTime by lazy {
        val now = NetworkDateTime.now()

        return@lazy if (now.minute < 40) {
            now - 1.hours - now.minute.minutes
        } else {
            now - now.minute.minutes
        }
    }
    private val nxny = ShortForecastMap.toNxNy(latitude, longitude)

    override val baseDate: String get() = baseDateTime.date.toString()
    override val baseTime: String get() = baseDateTime.time.toString()
    override val nx: Int get() = nxny.first
    override val ny: Int get() = nxny.second

    init {
        require(numOfRows in 1..100) { "numOfRows must be in 1..100" }
        require(pageNo > 0) { "pageNo must be greater than 0" }
    }
}

/**
 * ### 초단기 예보 요청
 *
 * 매시간 30분에 생성되고 10분마다 최신 정보로 갱신된다.
 *
 * |기준시간|생성시각|base_time|api 제공 시간(~이후)|
 * |:---:|:---:|:---:|:---:|
 * |00시|00:30|0030|00:45|
 * |01시|01:30|0130|01:45|
 * |02시|02:30|0230|02:45|
 * |03시|03:30|0330|03:45|
 * |04시|04:30|0430|04:45|
 * |05시|05:30|0530|05:45|
 * |06시|06:30|0630|06:45|
 * |07시|07:30|0730|07:45|
 * |08시|08:30|0830|08:45|
 * |09시|09:30|0930|09:45|
 * |10시|10:30|1030|10:45|
 * |11시|11:30|1130|11:45|
 * |12시|12:30|1230|12:45|
 * |13시|13:30|1330|13:45|
 * |14시|14:30|1430|14:45|
 * |15시|15:30|1530|15:45|
 * |16시|16:30|1630|16:45|
 * |17시|17:30|1730|17:45|
 * |18시|18:30|1830|18:45|
 * |19시|19:30|1930|19:45|
 * |20시|20:30|2030|20:45|
 * |21시|21:30|2130|21:45|
 * |22시|22:30|2230|22:45|
 * |23시|23:30|2330|23:45|
 */
data class UltraShortForecastRequest(
    override val numOfRows: Int = 100,
    override val pageNo: Int = 1,
    override val dataType: DataType = DataType.JSON,
    override val latitude: Double = 37.506406,
    override val longitude: Double = 127.05943,
) : Request {

    private val baseDateTime: NetworkDateTime by lazy {
        val now = NetworkDateTime.now()

        return@lazy if (now.minute < 45) {
            now - 1.hours - now.minute.minutes + 30.minutes
        } else {
            now - now.minute.minutes + 30.minutes
        }
    }
    private val nxny = ShortForecastMap.toNxNy(latitude, longitude)

    override val baseDate: String get() = baseDateTime.date.toString()
    override val baseTime: String get() = baseDateTime.time.toString()
    override val nx: Int get() = nxny.first
    override val ny: Int get() = nxny.second

    init {
        require(numOfRows in 1..100) { "numOfRows must be in 1..100" }
        require(pageNo > 0) { "pageNo must be greater than 0" }
    }
}

/**
 * ### 단기 예보 요청
 *
 * 1일 8회 생성됩니다.
 *
 * |기준시간|생성시각|base_time|api 제공 시간(~이후)|
 * |:---:|:---:|:---:|:---:|
 * |02시|?|0200|02:10|
 * |05시|?|0500|05:10|
 * |08시|?|0800|08:10|
 * |11시|?|1100|11:10|
 * |14시|?|1400|14:10|
 * |17시|?|1700|17:10|
 * |20시|?|2000|20:10|
 * |23시|?|2300|23:10|
 */
data class ShortForecastRequest(
    override val numOfRows: Int = 100,
    override val pageNo: Int = 1,
    override val dataType: DataType = DataType.JSON,
    override val latitude: Double = 37.506406,
    override val longitude: Double = 127.05943,
) : Request {

    private val baseDateTime: NetworkDateTime by lazy {
        val now = NetworkDateTime.now()

        return@lazy when {
            // 어제 23시
            now.hour in 0..1 || (now.hour == 2 && now.minute in 0..9) -> now - (now.hour + 1).hours - now.minute.minutes
            // 오늘 2시
            (now.hour in 2..4) || (now.hour == 5 && now.minute in 0..9) -> now - (now.hour - 2).hours - now.minute.minutes
            // 오늘 5시
            (now.hour in 5..7) || (now.hour == 8 && now.minute in 0..9) -> now - (now.hour - 5).hours - now.minute.minutes
            // 오늘 8시
            (now.hour in 8..10) || (now.hour == 11 && now.minute in 0..9) -> now - (now.hour - 8).hours - now.minute.minutes
            // 오늘 11시
            (now.hour in 11..13) || (now.hour == 14 && now.minute in 0..9) -> now - (now.hour - 11).hours - now.minute.minutes
            // 오늘 14시
            (now.hour in 14..16) || (now.hour == 17 && now.minute in 0..9) -> now - (now.hour - 14).hours - now.minute.minutes
            // 오늘 17시
            (now.hour in 17..19) || (now.hour == 20 && now.minute in 0..9) -> now - (now.hour - 17).hours - now.minute.minutes
            // 오늘 20시
            (now.hour in 20..22) || (now.hour == 23 && now.minute in 0..9) -> now - (now.hour - 20).hours - now.minute.minutes
            // 오늘 23시
            else -> now - now.minute.minutes
        }
    }
    private val nxny = ShortForecastMap.toNxNy(latitude, longitude)

    override val baseDate: String get() = baseDateTime.date.toString()
    override val baseTime: String get() = baseDateTime.time.toString()
    override val nx: Int get() = nxny.first
    override val ny: Int get() = nxny.second

    init {
        require(numOfRows in 1..100) { "numOfRows must be in 1..100" }
        require(pageNo > 0) { "pageNo must be greater than 0" }
    }
}
