plugins {
    alias(libs.plugins.simpleweatherandroid.android.library)
    alias(libs.plugins.simpleweatherandroid.android.library.compose)
    alias(libs.plugins.simpleweatherandroid.android.hilt)
}

android {
    namespace = "blog.jinhyun.simpleweatherandroid.core.ui"
}

dependencies {  }