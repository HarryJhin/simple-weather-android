plugins {
    alias(libs.plugins.simpleweatherandroid.android.library)
    alias(libs.plugins.simpleweatherandroid.android.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "blog.jinhyun.simpleweatherandroid.core.common"
}

dependencies {
    api(libs.kotlinx.datetime)
    api(libs.kotlinx.serialization.core)
}