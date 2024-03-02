import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.simpleweatherandroid.android.application)
    alias(libs.plugins.simpleweatherandroid.android.application.compose)
    alias(libs.plugins.simpleweatherandroid.android.hilt)
}

android {
    defaultConfig {
        applicationId = "blog.jinhyun.simpleweatherandroid"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level
    }
    signingConfigs {
        val localProperties = Properties().apply {
            load(FileInputStream(file("../local.properties")))
        }
        create("release") {
            storeFile = file(localProperties.getProperty("signingConfig.storeFile"))
            storePassword = localProperties.getProperty("signingConfig.storePassword")
            keyAlias = localProperties.getProperty("signingConfig.keyAlias")
            keyPassword = localProperties.getProperty("signingConfig.keyPassword")
        }
    }
    buildTypes {
        debug {
            applicationIdSuffix = ".debug"
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("debug")
        }
    }
    namespace = "blog.jinhyun.simpleweatherandroid"
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.core.ktx)
}