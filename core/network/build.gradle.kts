plugins {
    alias(libs.plugins.simpleweatherandroid.android.library)
    alias(libs.plugins.simpleweatherandroid.android.hilt)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.secret.gradle.plugin)
}

android {
    defaultConfig {
        testInstrumentationRunner = "blog.jinhyun.simpleweatherandroid.core.testing.TestRunner"
    }
    buildFeatures {
        buildConfig = true
    }
    namespace = "blog.jinhyun.simpleweatherandroid.core.network"
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

secrets {
    defaultPropertiesFileName = "secrets.properties"
}

dependencies {
    api(projects.core.common)
    api(libs.kotlinx.datetime)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit)
    implementation(libs.retrofit.kotlinx.serialization)

    testImplementation(libs.kotlinx.coroutines.test)
    androidTestImplementation(projects.core.testing)

    // FIXME: https://github.com/google/guava/issues/6618
    modules {
        module("com.google.guava:listenablefuture") {
            replacedBy("com.google.guava:guava", "listenablefuture is part of guava")
        }
    }
}