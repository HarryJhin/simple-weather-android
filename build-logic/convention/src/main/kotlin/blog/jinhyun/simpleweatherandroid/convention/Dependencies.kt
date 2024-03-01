package blog.jinhyun.simpleweatherandroid.convention

import org.gradle.kotlin.dsl.support.delegates.DependencyHandlerDelegate

fun DependencyHandlerDelegate.implementation(dependencyNotation: Any) {
    add("implementation", dependencyNotation)
}

fun DependencyHandlerDelegate.kapt(dependencyNotation: Any) {
    add("kapt", dependencyNotation)
}

fun DependencyHandlerDelegate.testImplementation(dependencyNotation: Any) {
    add("testImplementation", dependencyNotation)
}

fun DependencyHandlerDelegate.androidTestImplementation(dependencyNotation: Any) {
    add("androidTestImplementation", dependencyNotation)
}