package blog.jinhyun.simpleweatherandroid.convention

@Suppress("EnumEntryName")
enum class AppProductFlavor(
    val dimension: AppFlavorDimension,
    val applicationIdSuffix: String? = null
) {
    demo(dimension = AppFlavorDimension.contentType, applicationIdSuffix = ".demo"),
    prod(dimension = AppFlavorDimension.contentType)
}