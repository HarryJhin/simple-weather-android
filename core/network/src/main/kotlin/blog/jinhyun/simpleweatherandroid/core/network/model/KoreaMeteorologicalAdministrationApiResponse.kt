package blog.jinhyun.simpleweatherandroid.core.network.model

import blog.jinhyun.simpleweatherandroid.core.network.exception.KoreaMeteorologicalAdministrationApiException
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class KoreaMeteorologicalAdministrationApiResponse<T>(
    val response: Response<T>,
) {

    private val isSuccess: Boolean = response.header.code == "00"

    fun checkIsSuccess(): KoreaMeteorologicalAdministrationApiResponse<T> {
        if (!isSuccess) {
            throw KoreaMeteorologicalAdministrationApiException(response.header.code, response.header.message)
        }
        return this
    }
}

@Serializable
internal data class Response<T>(
    @SerialName("header")
    val header: Header,
    @SerialName("body")
    val body: Body<T>? = null,
)

@Serializable
internal data class Header(
    @SerialName("resultCode")
    val code: String,
    @SerialName("resultMsg")
    val message: String,
)

@Serializable
internal data class Body<T>(
    @SerialName("dataType")
    val dateType: DataType,
    @SerialName("items")
    val items: Items<T>,
    @SerialName("pageNo")
    val pageNo: Int,
    @SerialName("numOfRows")
    val numOfRows: Int,
    @SerialName("totalCount")
    val totalCount: Int,
)

@Serializable
internal data class Items<T>(
    @SerialName("item")
    val item: List<T>,
)