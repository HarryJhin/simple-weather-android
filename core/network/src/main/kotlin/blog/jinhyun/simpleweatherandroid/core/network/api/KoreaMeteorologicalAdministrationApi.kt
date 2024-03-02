package blog.jinhyun.simpleweatherandroid.core.network.api

import blog.jinhyun.simpleweatherandroid.core.network.model.DataType
import blog.jinhyun.simpleweatherandroid.core.network.model.KoreaMeteorologicalAdministrationApiResponse
import blog.jinhyun.simpleweatherandroid.core.network.model.ShortForecast
import blog.jinhyun.simpleweatherandroid.core.network.model.UltraShortNowcast
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * ### 기상청 API
 *
 * 초단기실황, 초단기예보, 단기예보, 예보버전 정보를 조회하는 서비스입니다.
 * 초단기실황정보는 예보 구역에 대한 대표 AWS 관측값을, 초단기예보는 예보시점부터 6시간 이내의 예보를, 단기예보는 예보기간과 구역을 시공간적으로 세분화한 예보를 제공합니다.
 */
internal interface KoreaMeteorologicalAdministrationApi {

    /**
     * ### 초단기 실황 조회
     *
     * 실황정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표, 예보지점 Y 좌표의 조회 조건으로 자료구분코드, 실황값, 발표일자, 발표시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를 조회하는 기능
     *
     * @param serviceKey 공공데이터포털에서 발급받은 인증키 | size: 100
     * @param numOfRows 한 페이지 결과 수 (default: 10) | size: 4
     * @param pageNo 페이지 번호 (default: 1) | size: 4
     * @param dataType 요청자료형식 (default: JSON) | size: 4
     * @param baseDate 발표일자 (yyyyMMdd) | size: 8
     * @param baseTime 발표시각 (HHmm) | size: 4
     * @param nx 예보지점 X 좌표 | size: 2
     * @param ny 예보지점 Y 좌표 | size: 2
     */
    @GET("/1360000/VilageFcstInfoService_2.0/getUltraSrtNcst")
    suspend fun getUltraShortNowcast(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: DataType = DataType.JSON,
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: String,
        @Query("nx") nx: Int,
        @Query("ny") ny: Int,
    ): KoreaMeteorologicalAdministrationApiResponse<UltraShortNowcast>

    /**
     * ### 초단기 예보 조회
     *
     * 초단기예보정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X 좌표, 예보지점 Y 좌표의 조회 조건으로 자료구분코드, 예보값, 발표일자, 발표시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를 조회하는 기능
     *
     * @param serviceKey 공공데이터포털에서 발급받은 인증키 | size: 100
     * @param numOfRows 한 페이지 결과 수 (default: 10) | size: 4
     * @param pageNo 페이지 번호 (default: 1) | size: 4
     * @param dataType 요청자료형식 (default: JSON) | size: 4
     * @param baseDate 발표일자 (yyyyMMdd) | size: 8
     * @param baseTime 발표시각 (HHmm) | size: 4
     * @param nx 예보지점 X 좌표 | size: 2
     * @param ny 예보지점 Y 좌표 | size: 2
     */
    @GET("/1360000/VilageFcstInfoService_2.0/getUltraSrtFcst")
    suspend fun getUltraShortForecast(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: DataType = DataType.JSON,
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: String,
        @Query("nx") nx: Int,
        @Query("ny") ny: Int,
    ): KoreaMeteorologicalAdministrationApiResponse<ShortForecast>

    /**
     * ### 단기 예보 조회
     *
     * 단기예보 정보를 조회하기 위해 발표일자, 발표시각, 예보지점 X좌표, 예보지점 Y 좌표의 조회 조건으로 발표일자, 발표시각, 자료구분문자, 예보 값, 예보일자, 예보시각, 예보지점 X 좌표, 예보지점 Y 좌표의 정보를 조회하는 기능
     *
     * @param serviceKey 공공데이터포털에서 발급받은 인증키 | size: 100
     * @param numOfRows 한 페이지 결과 수 (default: 10) | size: 4
     * @param pageNo 페이지 번호 (default: 1) | size: 4
     * @param dataType 요청자료형식 (default: JSON) | size: 4
     * @param baseDate 발표일자 (yyyyMMdd) | size: 8
     * @param baseTime 발표시각 (HHmm) | size: 4
     * @param nx 예보지점 X 좌표 | size: 2
     * @param ny 예보지점 Y 좌표 | size: 2
     */
    @GET("/1360000/VilageFcstInfoService_2.0/getVilageFcst")
    suspend fun getShortForecast(
        @Query("serviceKey") serviceKey: String,
        @Query("numOfRows") numOfRows: Int = 10,
        @Query("pageNo") pageNo: Int = 1,
        @Query("dataType") dataType: DataType = DataType.JSON,
        @Query("base_date") baseDate: String,
        @Query("base_time") baseTime: String,
        @Query("nx") nx: Int,
        @Query("ny") ny: Int,
    ): KoreaMeteorologicalAdministrationApiResponse<ShortForecast>
}