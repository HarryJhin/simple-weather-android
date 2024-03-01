import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "blog.jinhyun.simpleweatherandroid.buildlogic"

// JDK 17 대상으로 `build-logic` 플러그인을 구성합니다.
// `build-logic`의 플러그인을 구성하여 `simple-weather-android` 프로젝트를 빌드하는 데 사용된 JDK와 일치하도록 합니다.
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    compileOnly(libs.android.gradle)
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "simpleweatherandroid.android.application"
            implementationClass = "AndroidApplicationPlugin"
        }
    }
}