package blog.jinhyun.simpleweatherandroid.convention

import com.android.build.api.dsl.AndroidResources
import com.android.build.api.dsl.BuildFeatures
import com.android.build.api.dsl.BuildType
import com.android.build.api.dsl.CommonExtension
import com.android.build.api.dsl.DefaultConfig
import com.android.build.api.dsl.Installation
import com.android.build.api.dsl.ProductFlavor
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.provideDelegate
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/**
 * 모듈 수준의 build.gradle.kts에 적용할 플러그인을 설정합니다.
 *
 * ```kotlin
 * plugins {
 *   id("${plugin}")
 *   ...
 * }
 */
fun Project.plugins(vararg plugin: String) {
    with(pluginManager) {
        plugin.forEach(::apply)
    }
}

/**
 * android 설정을 위한 확장 함수입니다.
 *
 * ```kotlin
 * android {
 *   // action
 *   ...
 * }
 * ```
 */
inline fun <reified T : Any> Project.android(noinline action: T.() -> Unit) {
    extensions.configure<T> {
        action()
    }
}

/**
 * 모듈에 공통적으로 적용할 android 설정 구성입니다.
 *
 * 1. `compileSdk` 설정
 * 2. `minSdk` 설정
 * 3. `compileOptions` 설정 (sourceCompatibility, targetCompatibility, coreLibraryDesugaringEnabled)
 * 4. `dependencies` 설정 (coreLibraryDesugaring)
 *
 * ```kotlin
 * android {
 *   compileSdk = ?
 *   defaultConfig {
 *     minSdk = ?
 *     ...
 *   }
 *   compileOptions {
 *     sourceCompatibility = JavaVersion.VERSION_17
 *     targetCompatibility = JavaVersion.VERSION_17
 *     isCoreLibraryDesugaringEnabled = true
 *     ...
 *   }
 * }
 *
 * dependencies {
 *   coreLibraryDesugaring(libs.android.desugar.jdk.libs)
 *   ...
 * }
 * ```
 */
fun <BuildFeaturesT : BuildFeatures,
    BuildTypeT : BuildType,
    DefaultConfigT : DefaultConfig,
    ProductFlavorT : ProductFlavor,
    AndroidResourcesT : AndroidResources,
    InstallationT : Installation> Project.configureKotlinAndroid(
    extension: CommonExtension<
        BuildFeaturesT,
        BuildTypeT,
        DefaultConfigT,
        ProductFlavorT,
        AndroidResourcesT,
        InstallationT>
) {
    with(extension) {
        compileSdk = this@configureKotlinAndroid.compileSdk

        defaultConfig.minSdk = this@configureKotlinAndroid.minSdk

        compileOptions {
            // java.time 라이브러리 중 최소 지원 sdk 버전보다 더 낮은 버전의 sdk(minSdk)를 지원하는 경우에는 desugaring이 필요합니다.
            // https://developer.android.com/studio/write/java11-minimal-support-table
            sourceCompatibility = JavaVersion.VERSION_17
            targetCompatibility = JavaVersion.VERSION_17
            isCoreLibraryDesugaringEnabled = true
        }
    }

    configureKotlin()

    dependencies {
        add("coreLibraryDesugaring", libs.findLibrary("android.desugar.jdk.libs").get())
    }
}

private fun Project.configureKotlin() {
    // Use withType to workaround https://youtrack.jetbrains.com/issue/KT-55947
    tasks.withType<KotlinCompile>().configureEach {
        kotlinOptions {
            // Set JVM target to 17
            jvmTarget = JavaVersion.VERSION_17.toString()
            // 모든 경고를 오류로 처리합니다.
            // gradle.properties에서 warningsAsErrors=true로 설정하여 오버라이드할 수 있습니다.
            val warningsAsErrors: String? by project
            allWarningsAsErrors = warningsAsErrors.toBoolean()
            freeCompilerArgs = freeCompilerArgs + listOf(
                // Enable experimental coroutines APIs, including Flow
                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi",
            )
        }
    }
}