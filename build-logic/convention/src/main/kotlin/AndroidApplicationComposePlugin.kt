import blog.jinhyun.simpleweatherandroid.convention.android
import blog.jinhyun.simpleweatherandroid.convention.configureCompose
import blog.jinhyun.simpleweatherandroid.convention.plugins
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidApplicationComposePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            plugins(
                "com.android.application",
            )

            android<ApplicationExtension> {
                configureCompose(this)
            }
        }
    }
}