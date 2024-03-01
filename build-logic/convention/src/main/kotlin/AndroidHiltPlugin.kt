import blog.jinhyun.simpleweatherandroid.convention.implementation
import blog.jinhyun.simpleweatherandroid.convention.ksp
import blog.jinhyun.simpleweatherandroid.convention.libs
import blog.jinhyun.simpleweatherandroid.convention.plugins
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                "com.google.devtools.ksp",
                "dagger.hilt.android.plugin"
            )

            dependencies {
                implementation(libs.findLibrary("hilt.android").get())
                ksp(libs.findLibrary("hilt.android.compiler").get())
            }
        }
    }
}