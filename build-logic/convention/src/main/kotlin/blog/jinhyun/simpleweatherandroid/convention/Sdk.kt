package blog.jinhyun.simpleweatherandroid.convention

import org.gradle.api.Project

/**
 * 프로젝트의 `compileSdk`를 가져옵니다.
 *
 * `gradle.properties`에서 `compileSdk`를 설정합니다.
 */
val Project.compileSdk: Int
    get() = property("compileSdk").toString().toInt()

/**
 * 프로젝트의 targetSdk를 가져옵니다.
 *
 * `gradle.properties`에서 `targetSdk`를 설정합니다.
 */
val Project.targetSdk: Int
    get() = property("targetSdk").toString().toInt()

/**
 * 프로젝트의 `minSdk`를 가져옵니다.
 *
 * `gradle.properties`에서 `minSdk`를 설정합니다.
 */
val Project.minSdk: Int
    get() = property("minSdk").toString().toInt()