import blog.jinhyun.simpleweatherandroid.convention.android
import blog.jinhyun.simpleweatherandroid.convention.configureCompose
import blog.jinhyun.simpleweatherandroid.convention.plugins
import com.android.build.api.dsl.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidLibraryComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                "com.android.library",
            )

            android<LibraryExtension> {
                configureCompose(this)
            }
        }
    }
}