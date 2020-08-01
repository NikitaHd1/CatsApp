object AndroidSdk {
    const val minSdkVersion = 21
    const val targetSdkVersion = 28
}

object Dependencies {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlinVersion}"
    const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    const val constraintLayout =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    const val ktxCore = "androidx.core:core-ktx:${Versions.core}"

    object Navigation {
        const val navigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val safeArgs =
            "androidx.navigation:navigation-safe-args-gradle-plugin:${Versions.navigation}"
    }

    object Glide {
        const val core = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val processor = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val okhttp3 = "com.github.bumptech.glide:okhttp3-integration:${Versions.glide}"
    }

    object Jetbrains {
        const val annotations = "org.jetbrains:annotations:${Versions.jetbrainsAnnotations}"
    }

    object Network {
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

        object Retrofit {
            const val core = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
            const val rx = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
            const val converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        }
    }

    object Database {
        object Room {
            const val runtime = "androidx.room:room-runtime:${Versions.room}"
            const val compiler = "androidx.room:room-compiler:${Versions.room}"
            const val rx = "androidx.room:room-rxjava2:${Versions.room}"
            const val kotlin = "androidx.room:room-ktx:${Versions.room}"
        }
    }

    object Dagger {
        const val runtime = "com.google.dagger:dagger:${Versions.dagger}"
        const val compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
        const val android = "com.google.dagger:dagger-android:${Versions.dagger}"
        const val support = "com.google.dagger:dagger-android-support:${Versions.dagger}"
        const val processor = "com.google.dagger:dagger-android-processor:${Versions.dagger}"
    }

    object Rx {
        const val java = "io.reactivex.rxjava2:rxjava:${Versions.rxjava}"
        const val android = "io.reactivex.rxjava2:rxandroid:${Versions.rxandroid}"
        const val kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxkotlin}"
    }
}

object Plugins {

    const val androidApplication = "com.android.application"
    const val safeArgs = "androidx.navigation.safeargs.kotlin"

    object Kotlin {
        const val kotlinAndroid = "kotlin-android"
        const val kotlinAndroidExtensions = "kotlin-android-extensions"
    }
}

object TestLibraries {
    const val junit4 = "junit:junit:${Versions.junit4}"
    const val testExt = "androidx.test.ext:junit:${Versions.testExt}"
    const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
}