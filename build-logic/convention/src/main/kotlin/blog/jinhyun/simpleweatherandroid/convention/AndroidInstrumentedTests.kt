package blog.jinhyun.simpleweatherandroid.convention

import com.android.build.api.variant.LibraryAndroidComponentsExtension
import org.gradle.api.Project

/**
 * `androidTest` 폴더가 없으면 불필요한 Android 통합 테스트를 비활성화합니다.
 *
 * 그렇지 않으면 다음 메시지와 함께 종료됩니다:
 * ```shell
 * > Starting 0 tests on AVD
 * ```
 */
internal fun LibraryAndroidComponentsExtension.disableUnnecessaryAndroidTests(
    project: Project,
) = beforeVariants {
    it.androidTest.enable = it.androidTest.enable
        && project.projectDir.resolve("src/androidTest").exists()
}