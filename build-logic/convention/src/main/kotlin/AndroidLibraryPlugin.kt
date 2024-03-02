import blog.jinhyun.simpleweatherandroid.convention.android
import blog.jinhyun.simpleweatherandroid.convention.configureFlavors
import blog.jinhyun.simpleweatherandroid.convention.configureKotlinAndroid
import blog.jinhyun.simpleweatherandroid.convention.implementation
import blog.jinhyun.simpleweatherandroid.convention.libs
import blog.jinhyun.simpleweatherandroid.convention.plugins
import blog.jinhyun.simpleweatherandroid.convention.testImplementation
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

@Suppress("Unused")
class AndroidLibraryPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                "com.android.library",
                "org.jetbrains.kotlin.android",
            )

            android<LibraryExtension> {
                defaultConfig.targetSdk = 34
                configureKotlinAndroid(this)
                configureFlavors(this)
            }

            dependencies {
                implementation(libs.findLibrary("androidx.tracing.ktx").get())

                testImplementation(kotlin("test"))
            }
        }
    }
}