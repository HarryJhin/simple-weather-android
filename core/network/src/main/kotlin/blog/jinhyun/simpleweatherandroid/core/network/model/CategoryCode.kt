package blog.jinhyun.simpleweatherandroid.core.network.model

import kotlinx.serialization.SerialName

/**
 * ### 기상청 기상정보 종류 코드
 *
 * - 단기예보
 * - 초단기실황
 * - 초단기예보
 */
enum class CategoryCode {
    /**
     * ### 단기예보
     *
     * 강수확률 (%)
     */
    @SerialName("POP")
    POP,

    /**
     * ### 단기예보, 초단기실황
     *
     * 강수형태 (코드값)
     */
    @SerialName("PTY")
    PTY,

    /**
     * 1시간 강수량 (mm)
     */
    @SerialName("PCP")
    PCP,

    /**
     * ### 단기예보, 초단기실황
     *
     * 습도 (%)
     */
    @SerialName("REH")
    REH,

    /**
     * ### 단기예보
     *
     * 1시간 적설량 (cm)
     */
    @SerialName("SNO")
    SNO,

    /**
     * ### 단기예보
     *
     * 하늘상태 (코드값)
     */
    @SerialName("SKY")
    SKY,

    /**
     * ### 단기예보
     *
     * 1시간 기온 (℃)
     */
    @SerialName("TMP")
    TMP,

    /**
     * ### 단기예보
     *
     * 일 최저기온 (℃)
     */
    @SerialName("TMN")
    TMN,

    /**
     * ### 단기예보
     *
     * 일 최고기온 (℃)
     */
    @SerialName("TMX")
    TMX,

    /**
     * ### 단기예보, 초단기실황
     *
     * 풍속(동서성분) (m/s)
     */
    @SerialName("UUU")
    UUU,

    /**
     * ### 단기예보, 초단기실황
     *
     * 풍속(남북성분) (m/s)
     */
    @SerialName("VVV")
    VVV,

    /**
     * ### 단기예보
     *
     * 파고 (M)
     */
    @SerialName("WAV")
    WAV,

    /**
     * ### 단기예보, 초단기실황
     *
     * 풍향 (deg)
     */
    @SerialName("VEC")
    VEC,

    /**
     * ### 단기예보, 초단기실황
     *
     * 풍속 (m/s)
     */
    @SerialName("WSD")
    WSD,

    /**
     * ### 초단기실황
     *
     * 기온 (℃)
     */
    @SerialName("T1H")
    T1H,

    /**
     * ### 초단기실황
     *
     * 1시간 강수량 (mm)
     */
    @SerialName("RN1")
    RN1,

    /**
     * ### 초단기예보
     *
     * 낙뢰 (kA)
     */
    @SerialName("LGT")
    LGT,
}