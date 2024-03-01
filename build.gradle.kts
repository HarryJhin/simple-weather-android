buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

// 프로젝트 전체에서 사용되는 모든 플러그인을 적용하지 않고 나열합니다.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.secret.gradle.plugin) apply false
}