# 프로젝트 공통 플러그인

## 프로젝트 공통 플러그인이란?

프로젝트 공통 플러그인은 프로젝트 빌드 스크립트에 공통으로 사용되는 플러그인을 정의한 스크립트입니다. 프로젝트 공통 플러그인을 사용하면 프로젝트 빌드 스크립트에 공통으로 사용되는 플러그인을 한 번에 관리할 수 있습니다.

## 프로젝트 공통 플러그인 적용 방법

프로젝트 공통 플러그인을 적용하려면 프로젝트 빌드 스크립트에 다음과 같이 적용하면 됩니다.

```groovy
plugins {
    id("simpleweatherandroid.android.application")
}
```

## 프로젝트 공통 플러그인 구조

프로젝트 공통 플러그인은 다음과 같은 구조로 구성됩니다.

```
build-logic/
├── convention/
│   └── src/
│       └── main/
│           └── kotlin/
│               └── AndroidApplicationConventionPlugin.kt
│               └── AndroidLibraryConventionPlugin.kt
│               └── AndroidTestConventionPlugin.kt
│               └── AndroidApplicationComposeConventionPlugin.kt
│               └── AndroidLibraryComposeConventionPlugin.kt
```

- [simpleweatherandroid.application.android](convention/src/main/kotlin/AndroidApplicationPlugin.kt): 안드로이드 애플리케이션용 공통 플러그인
- [simpleweatherandroid.library.android](convention/src/main/kotlin/AndroidLibraryPlugin.kt): 안드로이드 라이브러리용 공통 플러그인
- [simpleweatherandroid.test.android](convention/src/main/kotlin/AndroidTestPlugin.kt): 안드로이드 테스트용 공통 플러그인
- [simpleweatherandroid.application.android.compose](convention/src/main/kotlin/AndroidApplicationComposePlugin.kt): 안드로이드 애플리케이션용 공통 플러그인
- [simpleweatherandroid.library.android.compose](convention/src/main/kotlin/AndroidLibraryComposePlugin.kt): 안드로이드 라이브러리용 공통 플러그인