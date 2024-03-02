package blog.jinhyun.simpleweatherandroid.core.testing

import android.app.Application
import android.content.Context
import androidx.test.runner.AndroidJUnitRunner
import dagger.hilt.android.testing.HiltTestApplication

/**
 * Android 통합 테스트에서 Hilt를 사용하기 위한 테스트 러너
 */
class TestRunner : AndroidJUnitRunner() {

    override fun newApplication(
        cl: ClassLoader?,
        className: String?,
        context: Context?
    ): Application {

        return super.newApplication(cl, HiltTestApplication::class.java.name, context)
    }
}