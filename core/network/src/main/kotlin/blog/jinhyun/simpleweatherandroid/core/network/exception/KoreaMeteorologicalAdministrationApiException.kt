package blog.jinhyun.simpleweatherandroid.core.network.exception

class KoreaMeteorologicalAdministrationApiException(
    val resultCode: String,
    override val message: String? = null,
) : RuntimeException()