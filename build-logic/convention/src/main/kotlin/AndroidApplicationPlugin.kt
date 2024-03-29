import blog.jinhyun.simpleweatherandroid.convention.android
import blog.jinhyun.simpleweatherandroid.convention.configureFlavors
import blog.jinhyun.simpleweatherandroid.convention.configureKotlinAndroid
import blog.jinhyun.simpleweatherandroid.convention.implementation
import blog.jinhyun.simpleweatherandroid.convention.libs
import blog.jinhyun.simpleweatherandroid.convention.plugins
import blog.jinhyun.simpleweatherandroid.convention.targetSdk
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

@Suppress("Unused")
class AndroidApplicationPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                "com.android.application",
                "org.jetbrains.kotlin.android",
            )

            android<ApplicationExtension> {
                defaultConfig.targetSdk = targetSdk
                configureKotlinAndroid(this)
                configureFlavors(this)
            }

            dependencies {
                implementation(libs.findLibrary("androidx.tracing.ktx").get())
            }
        }
    }
}