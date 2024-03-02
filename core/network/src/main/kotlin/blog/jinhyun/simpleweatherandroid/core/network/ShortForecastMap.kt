package blog.jinhyun.simpleweatherandroid.core.network

import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.ln
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.tan

internal object ShortForecastMap {

    /**
     * X축 격자점 수
     */
    private const val MAX_X = 149

    /**
     * Y축 격자점 수
     */
    private const val MAX_Y = 253

    private const val RE = 6371.00877 // 지구 반경(km)
    private const val GRID = 5.0 // 격자 간격(km)
    private const val SLAT1 = 30.0 // 표준위도 1
    private const val SLAT2 = 60.0 // 표준위도 2
    private const val OLON = 126.0 // 기준점 경도
    private const val OLAT = 38.0 // 기준점 위도
    private const val XO = 210 / GRID // 기준점 X좌표
    private const val YO = 675 / GRID // 기준점 Y좌표

    private const val DEGRAD = Math.PI / 180.0
    private const val RADDEG = 180.0 / Math.PI

    private const val re = RE / GRID
    private const val slat1 = SLAT1 * DEGRAD
    private const val slat2 = SLAT2 * DEGRAD
    private const val olon = OLON * DEGRAD
    private const val olat = OLAT * DEGRAD

    private val sn =
        ln(cos(slat1) / cos(slat2)) / ln(tan(Math.PI * 0.25 + slat2 * 0.5) / tan(Math.PI * 0.25 + slat1 * 0.5))
    private val sf = tan(Math.PI * 0.25 + slat1 * 0.5).pow(sn) * cos(slat1) / sn
    private val ro = re * sf / tan(Math.PI * 0.25 + olat * 0.5).pow(sn)

    fun toLatLon(nx: Int, ny: Int): Pair<Double, Double> {

        val x1 = nx - 1
        val y1 = ny - 1

        val xn = x1 - XO
        val yn = ro - y1 + YO
        var ra = sqrt(xn * xn + yn * yn)
        if (sn < 0.0) ra = -ra
        val alat = 2.0 * atan((re * sf / ra).pow((1.0 / sn))) - Math.PI * 0.5

        val theta = when {
            abs(xn) <= 0.0 -> 0.0
            abs(yn) <= 0.0 && xn >= 0.0 -> Math.PI * 0.5
            abs(yn) <= 0.0 && xn < 0.0 -> -Math.PI * 0.5
            else -> atan(yn / xn)
        }
        val alon = theta / sn + olon

        return alat * RADDEG to alon * RADDEG
    }

    fun toNxNy(lat: Double, lon: Double): Pair<Int, Int> {

        val ra = re * sf / tan(Math.PI * 0.25 + lat * DEGRAD * 0.5).pow(sn)
        var theta = lon * DEGRAD - olon
        if (theta > Math.PI) theta -= 2.0 * Math.PI
        if (theta < -Math.PI) theta += 2.0 * Math.PI
        theta *= sn

        return (((ra * sin(theta)) + XO) + 1.5).toInt() to (((ro - ra * cos(theta)) + YO) + 1.5).toInt()
    }
}