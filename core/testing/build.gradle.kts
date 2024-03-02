plugins {
    alias(libs.plugins.simpleweatherandroid.android.library)
    alias(libs.plugins.simpleweatherandroid.android.library.compose)
    alias(libs.plugins.simpleweatherandroid.android.hilt)
}

android {
    namespace = "blog.jinhyun.simpleweatherandroid.core.testing"
}

dependencies {
    api(kotlin("test"))
    api(libs.androidx.compose.ui.test.junit4)
    api(libs.robolectric)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.test.manifest)

    implementation(projects.core.common)
    implementation(libs.androidx.test.rules)
    implementation(libs.androidx.test.runner)
    implementation(libs.kotlinx.coroutines.test)
    implementation(libs.robolectric.shadows.framework)
}